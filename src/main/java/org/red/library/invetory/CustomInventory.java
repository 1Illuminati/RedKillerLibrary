package org.red.library.invetory;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.red.library.nms.v1_16_R3.RInv1_16_R3;
import org.red.library.nms.v1_19_R3.RInv1_19_R3;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomInventory {
    private static final String version = Bukkit.getVersion();
    private static final Class<? extends RInventory> RInvClass;
    private final RInventory inventory;

    public CustomInventory(InventoryHolder owner, InventoryType type) {
        try {
            this.inventory = RInvClass.getConstructor(InventoryHolder.class, InventoryType.class).newInstance(owner, type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomInventory(InventoryHolder owner, InventoryType type, String title) {
        try {
            this.inventory = RInvClass.getConstructor(InventoryHolder.class, InventoryType.class, String.class).newInstance(owner, type, title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomInventory(InventoryType type) {
        this(null, type);
    }

    public CustomInventory(InventoryType type, String title) {
        this(null, type, title);
    }

    public CustomInventory(InventoryHolder owner, int size) {
        try {
            this.inventory = RInvClass.getConstructor(InventoryHolder.class, int.class).newInstance(owner, size);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomInventory(InventoryHolder owner, int size, String title) {
        try {
            this.inventory = RInvClass.getConstructor(InventoryHolder.class, int.class, String.class).newInstance(owner, size, title);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomInventory(int size) {
        this(null, size);
    }

    public CustomInventory(int size, String title) {
        this(null, size, title);
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

    public RInventory getInventory() {
        return this.inventory;
    }

    public void setButton(int slot, Button button) {
        getInventory().setButton(slot, button);
    }

    public Button getButton(int slot) {
        return getInventory().getButton(slot);
    }

    public boolean hasButton(int slot) {
        return getInventory().hasButton(slot);
    }

    public int getSize() {
        return getInventory().getSize();
    }

    public int getMaxStackSize() {
        return getInventory().getMaxStackSize();
    }

    public void setMaxStackSize(int i) {
        getInventory().setMaxStackSize(i);
    }

    @Nullable
    public ItemStack getItem(int i) {
        return getInventory().getItem(i);
    }

    public void setItem(int i, @Nullable ItemStack itemStack) {
        getInventory().setItem(i, itemStack);
    }

    @NotNull
    public HashMap<Integer, ItemStack> addItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return getInventory().addItem(itemStacks);
    }

    @NotNull
    public HashMap<Integer, ItemStack> removeItem(@NotNull ItemStack... itemStacks) throws IllegalArgumentException {
        return getInventory().removeItem(itemStacks);
    }

    @NotNull
    public ItemStack[] getContents() {
        return getInventory().getContents();
    }

    public void setContents(@NotNull ItemStack[] itemStacks) throws IllegalArgumentException {
        getInventory().setContents(itemStacks);
    }

    @NotNull
    public ItemStack[] getStorageContents() {
        return getInventory().getStorageContents();
    }

    public void setStorageContents(@NotNull ItemStack[] itemStacks) throws IllegalArgumentException {
        getInventory().setStorageContents(itemStacks);
    }

    public boolean contains(@NotNull Material material) throws IllegalArgumentException {
        return getInventory().contains(material);
    }

    @Contract("null -> false")
    public boolean contains(@Nullable ItemStack itemStack) {
        return getInventory().contains(itemStack);
    }

    public boolean contains(@NotNull Material material, int i) throws IllegalArgumentException {
        return getInventory().contains(material, i);
    }

    @Contract("null, _ -> false")
    public boolean contains(@Nullable ItemStack itemStack, int i) {
        return getInventory().contains(itemStack, i);
    }

    @Contract("null, _ -> false")
    public boolean containsAtLeast(@Nullable ItemStack itemStack, int i) {
        return getInventory().containsAtLeast(itemStack, i);
    }

    @NotNull
    public HashMap<Integer, ? extends ItemStack> all(@NotNull Material material) throws IllegalArgumentException {
        return getInventory().all(material);
    }

    @NotNull
    public HashMap<Integer, ? extends ItemStack> all(@Nullable ItemStack itemStack) {
        return getInventory().all(itemStack);
    }

    public int first(@NotNull Material material) throws IllegalArgumentException {
        return getInventory().first(material);
    }

    public int first(@NotNull ItemStack itemStack) {
        return getInventory().first(itemStack);
    }

    public int firstEmpty() {
        return getInventory().firstEmpty();
    }

    public boolean isEmpty() {
        return getInventory().isEmpty();
    }

    public void remove(@NotNull Material material) throws IllegalArgumentException {
        getInventory().remove(material);
    }

    public void remove(@NotNull ItemStack itemStack) {
        getInventory().remove(itemStack);
    }

    public void clear(int i) {
        getInventory().clear(i);
    }

    public void clear() {
        getInventory().clear();
    }

    @NotNull
    public List<HumanEntity> getViewers() {
        return getInventory().getViewers();
    }

    @NotNull
    public InventoryType getType() {
        return getInventory().getType();
    }

    @Nullable
    public InventoryHolder getHolder() {
        return getInventory().getHolder();
    }

    @NotNull
    public ListIterator<ItemStack> iterator() {
        return getInventory().iterator();
    }

    @NotNull
    public ListIterator<ItemStack> iterator(int i) {
        return getInventory().iterator(i);
    }

    @Nullable
    public Location getLocation() {
        return getInventory().getLocation();
    }

    public void forEach(Consumer<? super ItemStack> action) {
        getInventory().forEach(action);
    }

    public Spliterator<ItemStack> spliterator() {
        return getInventory().spliterator();
    }

    static {
        if (version.contains("1.16")) {
            RInvClass = RInv1_16_R3.class;
        } else if (version.contains("1.17")) {
            RInvClass = null;
        } else if (version.contains("1.18")) {
            RInvClass = null;
        } else if (version.contains("1.19")) {
            RInvClass = RInv1_19_R3.class;
        } else {
            throw new RuntimeException("Your server version is not supported by RedKillerLibrary.");
        }
    }
}
