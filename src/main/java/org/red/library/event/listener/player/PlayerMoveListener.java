package org.red.library.event.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;
import org.red.library.event.area.player.AreaPlayerMoveEvent;
import org.red.library.event.listener.AbstractListener;

public class PlayerMoveListener extends AbstractListener {
    @EventHandler
    public void event(PlayerMoveEvent event) {
        super.runPlayerAreaEvent(event, AreaPlayerMoveEvent.class);
    }
}
