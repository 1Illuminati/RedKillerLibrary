package org.red.library.event.listener.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.listener.AbstractListener;
import org.red.library.item.event.EventItemAnnotation;
import org.red.library.item.event.EventItemManager;

public class PlayerInteractListener extends AbstractListener {
    @EventHandler
    public void event(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.OFF_HAND)
            return;

        Player player = event.getPlayer();
        boolean sneaking = player.isSneaking();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        Action action = event.getAction();

        EventItemAnnotation.Act act = null;

        if (action == Action.LEFT_CLICK_AIR)
            act = sneaking ? EventItemAnnotation.Act.SHIFT_LEFT_CLICK_AIR : EventItemAnnotation.Act.LEFT_CLICK_AIR;
        else if (action == Action.LEFT_CLICK_BLOCK)
            act =  sneaking ? EventItemAnnotation.Act.SHIFT_LEFT_CLICK_BLOCK : EventItemAnnotation.Act.LEFT_CLICK_BLOCK;
        else if (action == Action.RIGHT_CLICK_AIR)
            act =  sneaking ? EventItemAnnotation.Act.SHIFT_RIGHT_CLICK_AIR : EventItemAnnotation.Act.RIGHT_CLICK_AIR;
        else if (action == Action.RIGHT_CLICK_BLOCK)
            act =  sneaking ? EventItemAnnotation.Act.SHIFT_RIGHT_CLICK_BLOCK : EventItemAnnotation.Act.RIGHT_CLICK_BLOCK;


        if (act != null)
            EventItemManager.runItemEvent(NewPlayer.getNewPlayer(player), mainHand, act, event);
    }
}
