package org.red.library.event.listener.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.red.library.event.listener.AbstractListener;
import org.red.library.invetory.CustomInventory;

public class InventoryClickListener extends AbstractListener {
    @EventHandler
    public void event(InventoryClickEvent event) {
        Inventory inventory = event.getClickedInventory();

        if (inventory instanceof CustomInventory customInventory) {
            try {
                customInventory.onClick(event);
            } catch (UnsupportedOperationException ignore) {}

            int clickedSlot = event.getRawSlot();

            if (customInventory.hasButton(clickedSlot))
                customInventory.getButton(clickedSlot).onClick(event);
        }
    }
}
