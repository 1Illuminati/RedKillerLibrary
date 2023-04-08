package org.red.library.world.timer;

import org.bukkit.boss.KeyedBossBar;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Timer {
    private final List<UUID> playerList = new ArrayList<>();
    private final KeyedBossBar keyedBossBar;
    private int time = 0;

    public Timer(KeyedBossBar keyedBossBar) {
        this.keyedBossBar = keyedBossBar;
    }

}
