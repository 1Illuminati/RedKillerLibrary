package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerJoinEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerJoinEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerJoinEvent event;

    public AreaPlayerJoinEvent(Area area, PlayerJoinEvent event) {
        super(area);
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public PlayerJoinEvent getEvent() {
        return event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
