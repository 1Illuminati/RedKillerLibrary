package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaAsyncPlayerChatEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final AsyncPlayerChatEvent event;

    public AreaAsyncPlayerChatEvent(Area area, AsyncPlayerChatEvent event) {
        super(area);
        this.event = event;
    }

    public AsyncPlayerChatEvent getEvent() {
        return event;
    }

    //@Override
    public String log() {
        return String.format("AreaAsyncPlayerChatEvent{area=%s, player=%s, message=%s}", getArea().log(),
                getEvent().getPlayer().getName(), getEvent().getMessage());
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
