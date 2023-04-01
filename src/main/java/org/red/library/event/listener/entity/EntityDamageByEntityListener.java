package org.red.library.event.listener.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.AbstractListener;
import org.red.library.item.event.EventItemAnnotation;
import org.red.library.item.event.EventItemManager;

public class EntityDamageByEntityListener extends AbstractListener {
    @EventHandler
    public void event(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        
        if (damager instanceof Player player) {
            ItemStack mainHand = player.getInventory().getItemInMainHand();
            EventItemManager.runItemEvent(NewPlayer.getNewPlayer(player), mainHand, EventItemAnnotation.Act.HIT, event);
        }
    }
}
