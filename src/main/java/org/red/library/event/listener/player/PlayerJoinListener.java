package org.red.library.event.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.AbstractListener;

public class PlayerJoinListener extends AbstractListener {
    @EventHandler
    public void event(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        NewPlayer newPlayer = NewPlayer.getNewPlayer(player);
        newPlayer.load();
    }
}
