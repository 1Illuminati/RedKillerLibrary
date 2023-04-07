package org.red.library.event.listener.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.red.library.event.area.player.AreaAsyncPlayerChatEvent;
import org.red.library.event.listener.AbstractListener;

public class AsyncPlayerChatListener extends AbstractListener {
    @EventHandler
    public void event(AsyncPlayerChatEvent event) {
        super.runPlayerAreaEvent(event, AreaAsyncPlayerChatEvent.class);
    }

}
