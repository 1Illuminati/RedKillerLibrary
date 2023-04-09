package org.red.library.world.timer;

import org.bukkit.Bukkit;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.entity.Player;
import org.red.library.event.TimerEndEvent;
import org.red.library.util.async.Scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    private final List<Player> playerList = new ArrayList<>();
    private final KeyedBossBar keyedBossBar;
    private final String name;
    private double time = 0;
    private double maxTime = 0;

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
        playerList.add(player);
    }

    public boolean containsPlayer(Player player) {
        return playerList.contains(player);
    }

    public void removePlayer(Player player) {
        playerList.remove(player);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void start() {
        for (Player player : playerList) {
            keyedBossBar.addPlayer(player);
        }
        Scheduler.infiniteRepeatScheduler(new Scheduler.RunnableEx() {
            @Override
            public void function() {
                time+=0.05;
                keyedBossBar.setProgress(time / maxTime);

                if (time >= maxTime) {
                    Bukkit.getPluginManager().callEvent(new TimerEndEvent(Timer.this));
                    playerList.forEach(keyedBossBar::removePlayer);
                    stop();
                }
            }
        }, 0, 1);
    }
}
