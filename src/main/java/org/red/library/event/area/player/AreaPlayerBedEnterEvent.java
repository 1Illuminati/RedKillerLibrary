package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerBedEnterEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerBedEnterEvent event;

    public AreaPlayerBedEnterEvent(Area area, PlayerBedEnterEvent event) {
        super(area);
        this.event = event;
    }

    public PlayerBedEnterEvent getEvent() {
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
