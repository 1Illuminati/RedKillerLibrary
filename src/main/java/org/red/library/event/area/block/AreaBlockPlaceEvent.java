package org.red.library.event.area.block;

import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockPlaceEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaBlockPlaceEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final BlockPlaceEvent event;

    public AreaBlockPlaceEvent(Area area, BlockPlaceEvent event) {
        super(area);
        this.event = event;
    }

    public BlockPlaceEvent getEvent() {
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
