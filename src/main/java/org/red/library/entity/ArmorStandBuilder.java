package org.red.library.entity;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.UUID;

public class ArmorStandBuilder {
    private static final Location tempLoc = new Location(Bukkit.getWorlds().get(0), 0, 0, 0);
    private final ArmorStand armorStand;
    private final Location spawnLoc;
    public ArmorStandBuilder(Location loc) {
        World world = loc.getWorld();
        if (world == null)
            throw new NullPointerException("world is null");

        this.armorStand = (ArmorStand) world.spawnEntity(tempLoc, EntityType.ARMOR_STAND);
        this.spawnLoc = loc;
    }
    public ArmorStandBuilder addAttachment(Plugin arg0, int arg1) {
        armorStand.addAttachment(arg0, arg1);
        return this;
    }
    public ArmorStandBuilder addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
        armorStand.addAttachment(arg0, arg1, arg2, arg3);
        return this;
    }
    public ArmorStandBuilder addAttachment(Plugin arg0, String arg1, boolean arg2) {
        armorStand.addAttachment(arg0, arg1, arg2);
        return this;
    }
    public ArmorStandBuilder addAttachment(Plugin arg0) {
        armorStand.addAttachment(arg0);
        return this;
    }
    public ArmorStandBuilder addPassenger(Entity arg0) {
        armorStand.addPassenger(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder addPotionEffect(PotionEffect arg0, boolean arg1) {
        armorStand.addPotionEffect(arg0, arg1);
        return this;
    }
    public ArmorStandBuilder addPotionEffect(PotionEffect arg0) {
        armorStand.addPotionEffect(arg0);
        return this;
    }
    public ArmorStandBuilder addPotionEffects(Collection<PotionEffect> arg0) {
        armorStand.addPotionEffects(arg0);
        return this;
    }
    public ArmorStandBuilder addScoreboardTag(String arg0) {
        armorStand.addScoreboardTag(arg0);
        return this;
    }
    public ArmorStandBuilder setAI(boolean arg0) {
        armorStand.setAI(arg0);
        return this;
    }
    public ArmorStandBuilder setArms(boolean arg0) {
        armorStand.setArms(arg0);
        return this;
    }
    public ArmorStandBuilder setBasePlate(boolean arg0) {
        armorStand.setBasePlate(arg0);
        return this;
    }
    public ArmorStandBuilder setBodyPose(EulerAngle arg0) {
        armorStand.setBodyPose(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setBoots(ItemStack arg0) {
        armorStand.setBoots(arg0);
        return this;
    }
    public ArmorStandBuilder setCanPickupItems(boolean arg0) {
        armorStand.setCanPickupItems(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setChestplate(ItemStack arg0) {
        armorStand.setChestplate(arg0);
        return this;
    }
    public ArmorStandBuilder setCollidable(boolean arg0) {
        armorStand.setCollidable(arg0);
        return this;
    }
    public ArmorStandBuilder setCustomName(String arg0) {
        armorStand.setCustomName(arg0);
        return this;
    }
    public ArmorStandBuilder setCustomNameVisible(boolean arg0) {
        armorStand.setCustomNameVisible(arg0);
        return this;
    }
    public ArmorStandBuilder setFallDistance(float arg0) {
        armorStand.setFallDistance(arg0);
        return this;
    }
    public ArmorStandBuilder setFireTicks(int arg0) {
        armorStand.setFireTicks(arg0);
        return this;
    }
    public ArmorStandBuilder setGliding(boolean arg0) {
        armorStand.setGliding(arg0);
        return this;
    }
    public ArmorStandBuilder setGlowing(boolean arg0) {
        armorStand.setGlowing(arg0);
        return this;
    }
    public ArmorStandBuilder setGravity(boolean arg0) {
        armorStand.setGravity(arg0);
        return this;
    }
    public ArmorStandBuilder setHeadPose(EulerAngle arg0) {
        armorStand.setHeadPose(arg0);
        return this;
    }
    public ArmorStandBuilder setHealth(double arg0) {
        armorStand.setHealth(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setHelmet(ItemStack arg0) {
        armorStand.setHelmet(arg0);
        return this;
    }
    public ArmorStandBuilder setInvulnerable(boolean arg0) {
        armorStand.setInvulnerable(arg0);
        return this;
    }
    public ArmorStandBuilder setInvisible(boolean arg0) {
        armorStand.setInvisible(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setItemInHand(ItemStack arg0) {
        armorStand.setItemInHand(arg0);
        return this;
    }
    public ArmorStandBuilder setLastDamage(double arg0) {
        armorStand.setLastDamage(arg0);
        return this;
    }
    public ArmorStandBuilder setLastDamageCause(EntityDamageEvent arg0) {
        armorStand.setLastDamageCause(arg0);
        return this;
    }
    public ArmorStandBuilder setLeashHolder(Entity arg0) {
        armorStand.setLeashHolder(arg0);
        return this;
    }
    public ArmorStandBuilder setLeftArmPose(EulerAngle arg0) {
        armorStand.setLeftArmPose(arg0);
        return this;
    }
    public ArmorStandBuilder setLeftLegPose(EulerAngle arg0) {
        armorStand.setLeftLegPose(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setLeggings(ItemStack arg0) {
        armorStand.setLeggings(arg0);
        return this;
    }
    public ArmorStandBuilder setMarker(boolean arg0) {
        armorStand.setMarker(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setMaxHealth(double arg0) {
        armorStand.setMaxHealth(arg0);
        return this;
    }
    public ArmorStandBuilder setMaximumAir(int arg0) {
        armorStand.setMaximumAir(arg0);
        return this;
    }
    public ArmorStandBuilder setMaximumNoDamageTicks(int arg0) {
        armorStand.setMaximumNoDamageTicks(arg0);
        return this;
    }
    public ArmorStandBuilder setMetadata(String arg0, MetadataValue arg1) {
        armorStand.setMetadata(arg0, arg1);
        return this;
    }
    public ArmorStandBuilder setNoDamageTicks(int arg0) {
        armorStand.setNoDamageTicks(arg0);
        return this;
    }
    public ArmorStandBuilder setOp(boolean arg0) {
        armorStand.setOp(arg0);
        return this;
    }
    @SuppressWarnings("deprecation")
    public ArmorStandBuilder setPassenger(Entity arg0) {
        armorStand.setPassenger(arg0);
        return this;
    }
    public ArmorStandBuilder setPortalCooldown(int arg0) {
        armorStand.setPortalCooldown(arg0);
        return this;
    }
    public ArmorStandBuilder setRemainingAir(int arg0) {
        armorStand.setRemainingAir(arg0);
        return this;
    }
    public ArmorStandBuilder setRemoveWhenFarAway(boolean arg0) {
        armorStand.setRemoveWhenFarAway(arg0);
        return this;
    }
    public ArmorStandBuilder setRightArmPose(EulerAngle arg0) {
        armorStand.setRightArmPose(arg0);
        return this;
    }
    public ArmorStandBuilder setRightLegPose(EulerAngle arg0) {
        armorStand.setRightLegPose(arg0);
        return this;
    }
    public ArmorStandBuilder setSilent(boolean arg0) {
        armorStand.setSilent(arg0);
        return this;
    }
    public ArmorStandBuilder setSmall(boolean arg0) {
        armorStand.setSmall(arg0);
        return this;
    }
    public ArmorStandBuilder setTicksLived(int arg0) {
        armorStand.setTicksLived(arg0);
        return this;
    }
    public ArmorStandBuilder setVelocity(Vector arg0) {
        armorStand.setVelocity(arg0);
        return this;
    }
    public ArmorStandBuilder setVisible(boolean arg0) {
        armorStand.setVisible(arg0);
        return this;
    }
    public ArmorStandBuilder teleport(Entity arg0, PlayerTeleportEvent.TeleportCause arg1) {
        armorStand.teleport(arg0, arg1);
        return this;
    }
    public ArmorStandBuilder teleport(Entity arg0) {
        armorStand.teleport(arg0);
        return this;
    }
    public ArmorStandBuilder teleport(Location arg0, PlayerTeleportEvent.TeleportCause arg1) {
        armorStand.teleport(arg0, arg1);
        return this;
    }
    public ArmorStandBuilder teleport(Location arg0) {
        armorStand.teleport(arg0);
        return this;
    }

    public ArmorStandBuilder addEquipmentLock(EquipmentSlot equipmentSlot, ArmorStand.LockType lockType) {
        armorStand.addEquipmentLock(equipmentSlot, lockType);
        return this;
    }

    public ArmorStandBuilder removeEquipmentLock(EquipmentSlot equipmentSlot, ArmorStand.LockType lockType) {
        armorStand.removeEquipmentLock(equipmentSlot, lockType);
        return this;
    }

    public ArmorStandBuilder setArrowCooldown(int i) {
        armorStand.setArrowCooldown(i);
        return this;
    }

    public ArmorStandBuilder setArrowsInBody(int i) {
        armorStand.setArrowsInBody(i);
        return this;
    }

    public ArmorStandBuilder removePotionEffect(PotionEffectType potionEffectType) {
        armorStand.removePotionEffect(potionEffectType);
        return this;
    }

    public ArmorStandBuilder setSwimming(boolean b) {
        armorStand.setSwimming(b);
        return this;
    }

    public ArmorStandBuilder attack(Entity entity) {
        armorStand.attack(entity);
        return this;
    }

    public ArmorStandBuilder swingMainHand() {
        armorStand.swingMainHand();
        return this;
    }

    public ArmorStandBuilder swingOffHand() {
        armorStand.swingOffHand();
        return this;
    }

    public <T> ArmorStandBuilder setMemory(MemoryKey<T> memoryKey, T t) {
        armorStand.setMemory(memoryKey, t);
        return this;
    }

    public ArmorStandBuilder damage(double v) {
        armorStand.damage(v);
        return this;
    }

    public ArmorStandBuilder damage(double v, Entity entity) {
        armorStand.damage(v, entity);
        return this;
    }

    public ArmorStandBuilder setAbsorptionAmount(double v) {
        armorStand.setAbsorptionAmount(v);
        return this;
    }

    @Deprecated
    public ArmorStandBuilder resetMaxHealth() {
        armorStand.resetMaxHealth();
        return this;
    }

    public ArmorStandBuilder setRotation(float v, float v1) {
        armorStand.setRotation(v, v1);
        return this;
    }

    public ArmorStandBuilder remove() {
        armorStand.remove();
        return this;
    }

    public ArmorStandBuilder setPersistent(boolean b) {
        armorStand.setPersistent(b);
        return this;
    }

    public ArmorStandBuilder playEffect(EntityEffect entityEffect) {
        armorStand.playEffect(entityEffect);
        return this;
    }

    public ArmorStandBuilder removeMetadata(String s, Plugin plugin) {
        armorStand.removeMetadata(s, plugin);
        return this;
    }

    public ArmorStandBuilder sendMessage(String s) {
        armorStand.sendMessage(s);
        return this;
    }

    public ArmorStandBuilder sendMessage(String[] strings) {
        armorStand.sendMessage(strings);
        return this;
    }

    public ArmorStandBuilder sendMessage(UUID uuid, String s) {
        armorStand.sendMessage(uuid, s);
        return this;
    }

    public ArmorStandBuilder sendMessage(UUID uuid, String[] strings) {
        armorStand.sendMessage(uuid, strings);
        return this;
    }

    public ArmorStandBuilder removeAttachment(PermissionAttachment permissionAttachment) {
        armorStand.removeAttachment(permissionAttachment);
        return this;
    }

    public ArmorStandBuilder recalculatePermissions() {
        armorStand.recalculatePermissions();
        return this;
    }

    public ArmorStand build() {
        armorStand.teleport(this.spawnLoc);
        return this.armorStand;
    }
}
