package org.red.library.event.listener.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.red.library.event.area.entity.AreaPlayerDeathEvent;
import org.red.library.event.listener.AbstractListener;

public class EntityEventListener extends AbstractListener {
    @EventHandler
    public void playerDeathEvent(PlayerDeathEvent event) {
        super.runEntityAreaEvent(event, AreaPlayerDeathEvent.class);
    }
}
