package org.red.library.event.listener.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.area.player.AreaPlayerJoinEvent;
import org.red.library.event.listener.AbstractListener;
import org.red.library.world.area.Area;

public class PlayerJoinListener extends AbstractListener {
    @EventHandler
    public void event(PlayerJoinEvent event) {
        NewPlayer newPlayer = NewPlayer.getNewPlayer(event.getPlayer());
        Location location = newPlayer.getLocation();

        for (Area area : super.getAreas(location))
            super.runAreaEvent(new AreaPlayerJoinEvent(area, event));
    }
}
