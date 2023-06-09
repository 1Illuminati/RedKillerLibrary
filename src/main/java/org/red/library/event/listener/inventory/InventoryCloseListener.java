package org.red.library.event.listener.inventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.red.library.event.listener.AbstractListener;
import org.red.library.invetory.RInventory;

public class InventoryCloseListener extends AbstractListener {
    @EventHandler
    public void event(InventoryCloseEvent event) {
        Inventory inventory = event.getInventory();

        if (inventory instanceof RInventory rInventory) {
            try {
                rInventory.onClose(event);
            } catch (UnsupportedOperationException ignore) {}
        }
    }
}
