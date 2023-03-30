package org.red.library.event.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.event.listener.AbstractListener;
import org.red.library.item.event.EventItemAnnotation;
import org.red.library.item.event.EventItemManager;

public class PlayerFishListener extends AbstractListener {
    @EventHandler
    public void event(PlayerFishEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EventItemManager.runItemEvent(mainHand, EventItemAnnotation.Act.FISHING, event);
    }
}
