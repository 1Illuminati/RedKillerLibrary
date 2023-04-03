package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerAnimationEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerAnimationEvent event;

    public AreaPlayerAnimationEvent(Area area, PlayerAnimationEvent event) {
        super(area);
        this.event = event;
    }

    public PlayerAnimationEvent getEvent() {
        return event;
    }

    //@Override
    public String log() {
        return String.format("AreaPlayerAnimationEvent{area=%s, player=%s, animation=%s}", getArea().log(),
                getEvent().getPlayer().getName(), getEvent().getAnimationType().name());
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
