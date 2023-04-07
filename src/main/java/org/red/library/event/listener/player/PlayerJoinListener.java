package org.red.library.event.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.area.player.AreaPlayerJoinEvent;
import org.red.library.event.listener.AbstractListener;

public class PlayerJoinListener extends AbstractListener {
    @EventHandler
    public void event(PlayerJoinEvent event) {
        NewPlayer newPlayer = NewPlayer.getNewPlayer(event.getPlayer());
        newPlayer.sendMessage("test");
        super.runPlayerAreaEvent(event, AreaPlayerJoinEvent.class);
    }
}
