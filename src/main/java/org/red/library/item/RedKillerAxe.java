package org.red.library.item;

import org.bukkit.event.player.PlayerInteractEvent;
import org.red.library.item.event.EventItem;
import org.red.library.item.event.EventItemAnnotation;

public class RedKillerAxe implements EventItem {
    @Override
    public String getCode() {
        return "red_killer_axe";
    }

    @EventItemAnnotation(act = EventItemAnnotation.Act.LEFT_CLICK_BLOCK)
    public void leftClickBlock(PlayerInteractEvent event) {
        
    }
}
