package org.red.library.nms.v1_16_R3;

import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftInventoryCustom;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.red.library.invetory.Button;
import org.red.library.invetory.CustomInventory;
import org.red.library.invetory.RInventory;

import java.util.HashMap;
import java.util.Map;

public class RInv1_16_R3 extends CraftInventoryCustom implements RInventory {
    private final Map<Integer, Button> buttonMap = new HashMap<>();
    private final CustomInventory customInventory;
    public RInv1_16_R3(InventoryHolder owner, InventoryType type, CustomInventory customInventory) {
        super(owner, type);
        this.customInventory = customInventory;
    }

    public RInv1_16_R3(InventoryHolder owner, InventoryType type, String title, CustomInventory customInventory) {
        super(owner, type, title);
        this.customInventory = customInventory;
    }

    public RInv1_16_R3(InventoryHolder owner, int size, CustomInventory customInventory) {
        super(owner, size);
        this.customInventory = customInventory;
    }

    public RInv1_16_R3(InventoryHolder owner, int size, String title, CustomInventory customInventory) {
        super(owner, size, title);
        this.customInventory = customInventory;
    }

    @Override
    public void setButton(int slot, Button button) {
        if (slot >= super.getSize())
            throw new IllegalArgumentException("slot value can`t over inventory size");

        this.buttonMap.put(slot, button);
    }

    @Override
    public Button getButton(int slot) {
        return this.buttonMap.get(slot);
    }

    @Override
    public boolean hasButton(int slot) {
        return this.buttonMap.containsKey(slot);
    }
    @Override
    public void onClick(InventoryClickEvent event) {
        this.customInventory.onClick(event);
    }

    @Override
    public void onClose(InventoryCloseEvent event) {
        this.customInventory.onClose(event);
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {
        this.customInventory.onOpen(event);
    }
}
