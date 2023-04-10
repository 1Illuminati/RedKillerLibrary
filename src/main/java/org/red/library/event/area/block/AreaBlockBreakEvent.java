package org.red.library.event.area.block;

import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaBlockBreakEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final BlockBreakEvent event;

    public AreaBlockBreakEvent(Area area, BlockBreakEvent event) {
        super(area);
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public BlockBreakEvent getEvent() {
        return event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
