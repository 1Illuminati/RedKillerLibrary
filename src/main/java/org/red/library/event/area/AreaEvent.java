package org.red.library.event.area;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bukkit.event.Event;
import org.red.library.world.area.Area;

import java.util.HashMap;
import java.util.Map;

public abstract class AreaEvent extends Event {
    private static final Map<Class<? extends AreaEvent>, Logger> loggers = new HashMap<>();
    private final Area area;
    protected AreaEvent(Area area) {
        this.area = area;
    }
    public abstract Event getEvent();
    public abstract String log();
    public Area getArea() {
        return area;
    }

    public Logger getLogger() {
        return loggers.computeIfAbsent(getClass(), LogManager::getLogger);
    }
}
