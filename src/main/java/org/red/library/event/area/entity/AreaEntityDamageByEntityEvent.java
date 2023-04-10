package org.red.library.event.area.entity;

import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaEntityDamageByEntityEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final EntityDamageByEntityEvent event;

    public AreaEntityDamageByEntityEvent(Area area, EntityDamageByEntityEvent event) {
        super(area);
        this.event = event;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public EntityDamageByEntityEvent getEvent() {
        return event;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }
}
