package org.red.library.item.ban;

import org.bukkit.Material;

import java.util.Collection;
import java.util.Set;

public interface HasBanMaterial {
    BanMaterial getBanMaterial(Material material);

    boolean hasBanMaterial(Material material);

    void registerBanMaterial(BanMaterial banMaterial);

    boolean isAllow(Material material, BanMaterial.Act act);

    Collection<BanMaterial> banMaterials();
}
