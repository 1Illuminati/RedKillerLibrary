package org.red.library.event.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.AbstractListener;
import org.red.library.event.area.player.AreaPlayerQuitEvent;

public class PlayerQuitListener extends AbstractListener {
    @EventHandler
    public void event(PlayerQuitEvent event) {
        NewPlayer newPlayer = NewPlayer.getNewPlayer(event.getPlayer());
        super.runPlayerAreaEvent(event, AreaPlayerQuitEvent.class);
        newPlayer.save();
    }
}
