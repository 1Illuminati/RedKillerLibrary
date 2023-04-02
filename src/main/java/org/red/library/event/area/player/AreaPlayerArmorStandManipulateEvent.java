package org.red.library.event.area.player;

import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerArmorStandManipulateEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerArmorStandManipulateEvent event;

    public AreaPlayerArmorStandManipulateEvent(Area area, PlayerArmorStandManipulateEvent event) {
        super(area);
        this.event = event;
    }

    public PlayerArmorStandManipulateEvent getEvent() {
        return event;
    }

    @Override
    public String log() {
        return String.format("AreaPlayerArmorStandManipulateEvent{area=%s, player=%s, slot=%s}", getArea().log(),
                getEvent().getPlayer().getName(), getEvent().getSlot().name());
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
