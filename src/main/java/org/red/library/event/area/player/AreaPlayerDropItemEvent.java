package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerDropItemEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerDropItemEvent event;

    public AreaPlayerDropItemEvent(Area area, PlayerDropItemEvent event) {
        super(area);
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public PlayerDropItemEvent getEvent() {
        return event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
