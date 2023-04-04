package org.red.library.item.ban;

import org.bukkit.Material;

public interface HasBanMaterial {
    BanMaterial getBanMaterial(Material material);

    boolean hasBanMaterial(Material material);

    void setBanMaterial(BanMaterial banMaterial);

    boolean isAllow(Material material, BanMaterial.Act act);
}
