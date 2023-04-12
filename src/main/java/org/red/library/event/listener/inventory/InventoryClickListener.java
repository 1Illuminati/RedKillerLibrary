package org.red.library.event.listener.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.red.library.event.listener.AbstractListener;
import org.red.library.invetory.RInventory;

public class InventoryClickListener extends AbstractListener {
    @EventHandler
    public void event(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();

        if (inventory instanceof RInventory rInventory) {
            try {
                rInventory.onClick(event);
            } catch (UnsupportedOperationException ignore) {}

            int clickedSlot = event.getRawSlot();

            if (rInventory.hasButton(clickedSlot))
                rInventory.getButton(clickedSlot).onClick(event);
        }
    }
}
