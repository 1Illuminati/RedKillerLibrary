package org.red.library.item.ban.inventory;

import org.red.library.invetory.CustomInventory;
import org.red.library.item.ban.BanMaterial;
import org.red.library.item.ban.HasBanMaterial;

public class BanMaterialSettingInventory extends CustomInventory {
    public BanMaterialSettingInventory(HasBanMaterial hasBanMaterial, BanMaterial banMaterial) {
        super(18);
    }
}
