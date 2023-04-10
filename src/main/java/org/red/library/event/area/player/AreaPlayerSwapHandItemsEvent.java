package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerSwapHandItemsEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerSwapHandItemsEvent event;

    public AreaPlayerSwapHandItemsEvent(Area area, PlayerSwapHandItemsEvent event) {
        super(area);
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public PlayerSwapHandItemsEvent getEvent() {
        return event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
