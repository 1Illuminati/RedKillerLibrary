package org.red.library.event.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.event.listener.AbstractListener;
import org.red.library.item.event.EventItemAnnotation;
import org.red.library.item.event.EventItemManager;

public class PlayerDropItemListener extends AbstractListener {
    @EventHandler
    public void event(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EventItemManager.runItemEvent(mainHand, player.isSneaking() ?
                EventItemAnnotation.Act.SHIFT_DROP : EventItemAnnotation.Act.DROP, event);
    }
}
