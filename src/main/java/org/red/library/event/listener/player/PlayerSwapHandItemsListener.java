package org.red.library.event.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.area.player.AreaPlayerSwapHandItemsEvent;
import org.red.library.event.listener.AbstractListener;
import org.red.library.item.event.EventItemAnnotation;
import org.red.library.item.event.EventItemManager;

public class PlayerSwapHandItemsListener extends AbstractListener {
    @EventHandler
    public void event(PlayerSwapHandItemsEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EventItemManager.runItemEvent(NewPlayer.getNewPlayer(player), mainHand, player.isSneaking() ?
                EventItemAnnotation.Act.SHIFT_SWAP_HAND : EventItemAnnotation.Act.SWAP_HAND, event);
        super.runPlayerAreaEvent(event, AreaPlayerSwapHandItemsEvent.class);
    }
}
