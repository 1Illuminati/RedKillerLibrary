package org.red.library.event.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.AbstractListener;

public class PlayerQuitListener extends AbstractListener {
    @EventHandler
    public void event(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        NewPlayer newPlayer = NewPlayer.getNewPlayer(player);
        newPlayer.save();
    }
}
