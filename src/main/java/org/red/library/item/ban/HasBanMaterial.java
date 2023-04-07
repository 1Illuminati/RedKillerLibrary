package org.red.library.item.ban;

import org.bukkit.Material;

import java.util.List;

public interface HasBanMaterial {
    BanMaterial getBanMaterial(Material material);

    boolean hasBanMaterial(Material material);

    void registerBanMaterial(BanMaterial banMaterial);

    boolean isAllow(Material material, BanMaterial.Act act);

    List<BanMaterial> banMaterials();
}
