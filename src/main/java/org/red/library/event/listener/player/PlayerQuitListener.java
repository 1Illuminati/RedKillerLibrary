package org.red.library.event.listener.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.AbstractListener;
import org.red.library.event.area.player.AreaPlayerQuitEvent;
import org.red.library.world.area.Area;

public class PlayerQuitListener extends AbstractListener {
    @EventHandler
    public void event(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        NewPlayer newPlayer = NewPlayer.getNewPlayer(player);
        Location location = player.getLocation();

        for (Area area : super.getAreas(location))
            super.runAreaEvent(new AreaPlayerQuitEvent(area, event));

        newPlayer.save();
    }
}
