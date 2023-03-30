package org.red.library.event.listener.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.red.library.event.listener.AbstractListener;
import org.red.library.invetory.CustomInventory;

public class InventoryOpenListener extends AbstractListener {
    @EventHandler
    public void event(InventoryOpenEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory instanceof CustomInventory customInventory) {
            try {
                customInventory.onOpen(event);
            } catch (UnsupportedOperationException ignore) {}
        }
    }
}
