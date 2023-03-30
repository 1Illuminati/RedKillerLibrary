package org.red.library.item.event;

import org.bukkit.NamespacedKey;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.red.library.RedKillerLibrary;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventItemManager {
    private static final Map<String, EventItemInfo> map = new HashMap<>();
    private static final NamespacedKey key = new NamespacedKey(RedKillerLibrary.getPlugin(), "RedKillerLibrary_EventItem");

    public static void registerItemEvent(EventItem eventItem) {
        String code = eventItem.getCode();
        map.put(code, new EventItemInfo(eventItem));
    }

    public static void setItemInEvent(ItemStack itemStack, String code) {
        ItemMeta itemMeta;
        if (itemStack == null || (itemMeta = itemStack.getItemMeta()) == null)
            throw new NullPointerException("ItemStack is Air or Null");

        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
        persistentDataContainer.set(key, PersistentDataType.STRING, code);
        itemStack.setItemMeta(itemMeta);
    }

    public static boolean runItemEvent(ItemStack itemStack, EventItemAnnotation.Act act, Event event) {
        if (itemStack == null) {
            return false;
        }

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null) {
            return false;
        }

        PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();

        if (!persistentDataContainer.has(key, PersistentDataType.STRING))
            return false;

        String code = persistentDataContainer.get(key, PersistentDataType.STRING);

        if (!map.containsKey(code))
            return false;

        EventItemInfo info = map.get(code);
        return info.runEvent(act, event);
    }

    private EventItemManager() {
        throw new IllegalArgumentException("Utility Class");
    }

    private static class EventItemInfo {
        private final EventItem eventItem;
        private final Map<EventItemAnnotation.Act, Method> map = new HashMap<>();

        private EventItemInfo(EventItem eventItem) {
            this.eventItem = eventItem;
            Method[] methods = eventItem.getClass().getMethods();

            for (Method method : methods)
                this.putMethod(method);
        }

        private void putMethod(Method method) {
            if (!method.isAnnotationPresent(EventItemAnnotation.class))
                return;

            EventItemAnnotation.Act act = method.getAnnotation(EventItemAnnotation.class).act();
            Class<?>[] classes = method.getParameterTypes();

            if (classes.length != 1)
                return;

            Class<?> clazz = classes[0];
            if ((clazz.isAssignableFrom(PlayerSwapHandItemsEvent.class) && (act == EventItemAnnotation.Act.SWAP_HAND || act == EventItemAnnotation.Act.SHIFT_SWAP_HAND)) ||
                    (clazz.isAssignableFrom(PlayerDropItemEvent.class) && (act == EventItemAnnotation.Act.DROP || act == EventItemAnnotation.Act.SHIFT_DROP)) ||
                    (clazz.isAssignableFrom(EntityDamageByEntityEvent.class) && act == EventItemAnnotation.Act.HIT) ||
                    (clazz.isAssignableFrom(BlockBreakEvent.class) && act == EventItemAnnotation.Act.BREAK) ||
                    (clazz.isAssignableFrom(PlayerFishEvent.class) && act == EventItemAnnotation.Act.FISHING) ||
                    (clazz.isAssignableFrom(PlayerInteractEvent.class))) {
                map.put(act, method);
            }
        }


        private boolean runEvent(EventItemAnnotation.Act act, Event event) {
            if (!map.containsKey(act))
                return false;

            try {
                map.get(act).invoke(this.getItemEvent(), event);
                return true;
            } catch(Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        private EventItem getItemEvent() {
            return this.eventItem;
        }
    }
}
