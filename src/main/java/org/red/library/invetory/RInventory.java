package org.red.library.invetory;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public interface RInventory extends Inventory {
    void setButton(int slot, Button button);

    Button getButton(int slot);

    boolean hasButton(int slot);

    void onClick(InventoryClickEvent event);

    void onClose(InventoryCloseEvent event);

    void onOpen(InventoryOpenEvent event);
}
