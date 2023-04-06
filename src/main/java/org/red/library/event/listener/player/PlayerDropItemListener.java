package org.red.library.event.listener.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.red.library.entity.player.NewPlayer;
import org.red.library.event.area.player.AreaPlayerDropItemEvent;
import org.red.library.event.listener.AbstractListener;
import org.red.library.item.event.EventItemAnnotation;
import org.red.library.item.event.EventItemManager;
import org.red.library.world.area.Area;

public class PlayerDropItemListener extends AbstractListener {
    @EventHandler
    public void event(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        EventItemManager.runItemEvent(NewPlayer.getNewPlayer(player), mainHand, player.isSneaking() ?
                EventItemAnnotation.Act.SHIFT_DROP : EventItemAnnotation.Act.DROP, event);
        Location location = player.getLocation();

        for (Area area : super.getAreas(location))
            super.runAreaEvent(new AreaPlayerDropItemEvent(area, event));
    }
}
