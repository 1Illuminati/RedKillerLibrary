package org.red.library.event.listener.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.red.library.event.area.player.AreaAsyncPlayerChatEvent;
import org.red.library.event.listener.AbstractListener;
import org.red.library.world.area.Area;

public class AsyncPlayerChatListener extends AbstractListener {
    @EventHandler
    public void event(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Location location = player.getLocation();

        for (Area area : super.getAreas(location))
            super.runAreaEvent(new AreaAsyncPlayerChatEvent(area, event));
    }

}
