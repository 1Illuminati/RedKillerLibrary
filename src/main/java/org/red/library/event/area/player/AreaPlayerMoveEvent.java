package org.red.library.event.area.player;

import org.bukkit.Location;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerMoveEvent;
import org.red.library.event.area.AreaEvent;
import org.red.library.world.area.Area;

public class AreaPlayerMoveEvent extends AreaEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private final PlayerMoveEvent event;
    private final AreaMoveAct areaMoveAct;

    public AreaPlayerMoveEvent() {
        super(null);
        this.event = null;
        this.areaMoveAct = null;
    }

    public AreaPlayerMoveEvent(String test) {
        super(null);
        this.event = null;
        this.areaMoveAct = null;
    }

    public AreaPlayerMoveEvent(Area area, PlayerMoveEvent event) {
        super(area);
        this.event = event;

        Location form = event.getFrom();
        Location to = event.getTo();
        boolean formContain = area.contain(form);
        boolean toContain = area.contain(to);
        if (formContain && toContain) {
            this.areaMoveAct = AreaMoveAct.MOVE;
        } else {
            this.areaMoveAct = formContain ? AreaMoveAct.EXIT : AreaMoveAct.ENTER;
        }
    }

    public PlayerMoveEvent getEvent() {
        return event;
    }

    public AreaMoveAct getAreaMoveAct() {
        return areaMoveAct;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public enum AreaMoveAct {
        MOVE,
        EXIT,
        ENTER
    }
}
