package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.red.library.event.area.AreaEvent;
import org.red.library.event.RunEventItemEvent;
import org.red.library.world.area.Area;

public class AreaRunEventItemEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final RunEventItemEvent event;

    public AreaRunEventItemEvent(Area area, RunEventItemEvent event) {
        super(area);
        this.event = event;
    }

    public RunEventItemEvent getEvent() {
        return event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
