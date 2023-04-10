package org.red.library.item.ban.inventory;

import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.red.library.invetory.CustomInventory;
import org.red.library.item.ItemBuilder;
import org.red.library.item.ban.BanMaterial;
import org.red.library.item.ban.HasBanMaterial;

import java.util.ArrayList;
import java.util.List;

public class BanMaterialInventory extends CustomInventory {
    private final HasBanMaterial hasBanMaterial;

    public BanMaterialInventory(HasBanMaterial hasBanMaterial) {
        this(hasBanMaterial, 0);
    }

    public BanMaterialInventory(HasBanMaterial hasBanMaterial, int page) {
        super(54);
        this.hasBanMaterial = hasBanMaterial;
        List<BanMaterial> banMaterialList = hasBanMaterial.banMaterials();
        for (int i = 0; i < 45; i++) {
            BanMaterial banMaterial = banMaterialList.get(45 * page + i);
            Material material = banMaterial.getMaterial();
            List<String> lore = new ArrayList<>();

            for (BanMaterial.Act act : BanMaterial.Act.values()) {
                boolean allow = banMaterial.getAllow(act);
                lore.add("§f" + act.name() + " : " + (allow ? "§2" : "§4") + allow);
            }

            this.setItem(i, new ItemBuilder(material).setDisplayName(material.name()).setLore(lore).build());
        }
    }

    @Override
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        ClickType type = event.getClick();

        if (type == ClickType.LEFT) {

        } else if (type == ClickType.SHIFT_LEFT) {

        }
    }
}
