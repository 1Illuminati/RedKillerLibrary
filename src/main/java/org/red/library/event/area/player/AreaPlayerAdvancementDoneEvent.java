package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerAdvancementDoneEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerAdvancementDoneEvent event;

    public AreaPlayerAdvancementDoneEvent(Area area, PlayerAdvancementDoneEvent event) {
        super(area);
        this.event = event;
    }

    public PlayerAdvancementDoneEvent getEvent() {
        return event;
    }

    @Override
    public String log() {
        return String.format("AreaPlayerAdvancementDoneEvent{area=%s, player=%s, advancement=%s}", getArea().log(),
                getEvent().getPlayer().getName(), getEvent().getAdvancement().getKey());
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
