package org.red.library.invetory;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.function.Consumer;

public class CustomInventory implements Inventory {
    private final Inventory inventory;
    private final Map<Integer, Button> buttonMap;

    public CustomInventory(Inventory inventory) {
        this.inventory = inventory;
        buttonMap = new HashMap<>(inventory.getSize());
    }

    public CustomInventory(String title, int size) {
        this(Bukkit.createInventory(null, size, title));
    }

    public CustomInventory(int size) {
        this(Bukkit.createInventory(null, size));
    }

    public void setButton(int slot, Button button) {
        if (slot >= inventory.getSize())
            throw new IllegalArgumentException("slot value can`t over inventory size");

        this.buttonMap.put(slot, button);
    }

    public Button getButton(int slot) {
        return this.buttonMap.get(slot);
    }

    public boolean hasButton(int slot) {
        return this.buttonMap.containsKey(slot);
    }

    public void onClick(InventoryClickEvent event) {
        throw new UnsupportedOperationException();
    }

    public void onClose(InventoryCloseEvent event) {
        throw new UnsupportedOperationException();
    }

    public void onOpen(InventoryOpenEvent event) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        return inventory.getSize();
    }

    @Override
    public int getMaxStackSize() {
        return inventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        inventory.setMaxStackSize(i);
    }

    @Override
    public ItemStack getItem(int i) {
        return inventory.getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        inventory.setItem(i, itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return inventory.addItem(itemStacks);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return inventory.removeItem(itemStacks);
    }

    @Override
    public ItemStack[] getContents() {
        return inventory.getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        inventory.setContents(itemStacks);
    }

    @Override
    public ItemStack[] getStorageContents() {
        return inventory.getStorageContents();
    }

    @Override
    public void setStorageContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        inventory.setStorageContents(itemStacks);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return inventory.contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return inventory.contains(itemStack);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return inventory.contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return inventory.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return inventory.containsAtLeast(itemStack, i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return inventory.all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return inventory.all(itemStack);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return inventory.first(material);
    }

    @Override
    public int first(ItemStack itemStack) {
        return inventory.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return inventory.firstEmpty();
    }

    @Override
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        inventory.remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        inventory.remove(itemStack);
    }

    @Override
    public void clear(int i) {
        inventory.clear(i);
    }

    @Override
    public void clear() {
        inventory.clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return inventory.getViewers();
    }

    @Override
    public InventoryType getType() {
        return inventory.getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return inventory.getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return inventory.iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return inventory.iterator(i);
    }

    @Override
    public Location getLocation() {
        return inventory.getLocation();
    }

    @Override
    public void forEach(Consumer<? super ItemStack> action) {
        inventory.forEach(action);
    }

    @Override
    public Spliterator<ItemStack> spliterator() {
        return inventory.spliterator();
    }
}
