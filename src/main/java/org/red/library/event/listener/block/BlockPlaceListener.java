package org.red.library.event.listener.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.red.library.event.area.block.AreaBlockPlaceEvent;
import org.red.library.event.listener.AbstractListener;

public class BlockPlaceListener extends AbstractListener {
    @EventHandler
    public void event(BlockPlaceEvent event) {
        super.runBlockAreaEvent(event, AreaBlockPlaceEvent.class);
    }
}
