package org.red.library.world.timer;

import org.bukkit.Bukkit;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.red.library.RedKillerLibrary;
import org.red.library.event.TimerEndEvent;
import org.red.library.util.async.Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Timer {
    private static final HashMap<String, Timer> timers = new HashMap<>();
    public static Timer getTimer(String name) {
        return timers.get(name);
    }

    public static void registerTimer(Timer timer) {
        timers.put(timer.getName(), timer);
    }
    public static void removeTimer(String name) {
        timers.remove(name);
    }
    private final List<UUID> playerList = new ArrayList<>();
    private final KeyedBossBar keyedBossBar;
    private final String name;
    private double time = 0;
    private double maxTime;

    public Timer(String name, KeyedBossBar keyedBossBar, int maxTime) {
        this.name = name;
        this.keyedBossBar = keyedBossBar;
        this.maxTime = maxTime;
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public double getMaxTime() {
        return maxTime;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setMaxTime(double maxTime) {
        this.maxTime = maxTime;
    }

    public void addTime(double time) {
        this.time += time;
    }

    public void addMaxTime(double time) {
        this.maxTime += time;
    }

    public void addPlayer(Player player) {
        RedKillerLibrary.sendLog("test");
        playerList.add(player.getUniqueId());
    }

    public boolean containsPlayer(Player player) {
        return playerList.contains(player.getUniqueId());
    }

    public void removePlayer(Player player) {
        playerList.remove(player.getUniqueId());
    }

    public List<UUID> getPlayerList() {
        return playerList;
    }

    public void start() {
        RedKillerLibrary.sendDebugLog(playerList.size());
        for (UUID uuid : playerList) {
            Player player = Bukkit.getPlayer(uuid);
            if (player == null)
                continue;

            RedKillerLibrary.sendDebugLog(player.getName());
            keyedBossBar.addPlayer(player);
        }
        Scheduler.infiniteRepeatScheduler(new Scheduler.RunnableEx() {
            @Override
            public void function() {
                time+=0.05;
                if (time >= maxTime) {
                    Bukkit.getPluginManager().callEvent(new TimerEndEvent(Timer.this));
                    playerList.forEach(uuid -> {
                        Player player = Bukkit.getPlayer(uuid);
                        if (player == null)
                            return;

                        keyedBossBar.removePlayer(player);
                    });
                    playerList.clear();
                    stop();
                }
                keyedBossBar.setProgress(Math.round(time / maxTime * 100) * 0.01D);
            }
        }, 0, 1);
    }
}
