package org.red.library.event.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.red.library.RedKillerLibrary;
import org.red.library.event.RunEventItemEvent;
import org.red.library.event.area.player.AreaRunEventItemEvent;
import org.red.library.event.listener.AbstractListener;

public class RunEventItemListener extends AbstractListener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void event(RunEventItemEvent event) {
        super.runPlayerAreaEvent(event, AreaRunEventItemEvent.class);
        RedKillerLibrary.sendDebugLog(String.format("RunEventItemEvent: player=%s, event=%s, act=%s", event.getPlayer().getName(), event.getEventItem().getCode(), event.getAct().name()));
    }
}
