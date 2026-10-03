package com.climaterra;

import java.util.EnumMap;
import java.util.function.Supplier;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

public enum TerraArmorMaterial implements ArmorMaterial {
    TERRA("climaterra:terra", 12, 8, SoundEvents.ARMOR_EQUIP_LEATHER, 0f, 0f,
            () -> Ingredient.of(Items.DIRT));

    private static final EnumMap<ArmorItem.Type, Integer> BASE_DURABILITY = new EnumMap<>(ArmorItem.Type.class);
    private static final EnumMap<ArmorItem.Type, Integer> DEFENSE = new EnumMap<>(ArmorItem.Type.class);
    static {
        BASE_DURABILITY.put(ArmorItem.Type.HELMET, 11);
        BASE_DURABILITY.put(ArmorItem.Type.CHESTPLATE, 16);
        BASE_DURABILITY.put(ArmorItem.Type.LEGGINGS, 15);
        BASE_DURABILITY.put(ArmorItem.Type.BOOTS, 13);
        DEFENSE.put(ArmorItem.Type.HELMET, 2);
        DEFENSE.put(ArmorItem.Type.CHESTPLATE, 5);
        DEFENSE.put(ArmorItem.Type.LEGGINGS, 4);
        DEFENSE.put(ArmorItem.Type.BOOTS, 2);
    }

    private final String name;
    private final int durabilityMultiplier;
    private final int enchantability;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockback;
    private final Supplier<Ingredient> repair;

    TerraArmorMaterial(String name, int mult, int ench, SoundEvent sound, float tough, float kb, Supplier<Ingredient> repair) {
        this.name = name; this.durabilityMultiplier = mult; this.enchantability = ench;
        this.sound = sound; this.toughness = tough; this.knockback = kb; this.repair = repair;
    }

    @Override public int getDurabilityForType(ArmorItem.Type t) { return BASE_DURABILITY.get(t) * durabilityMultiplier; }
    @Override public int getDefenseForType(ArmorItem.Type t) { return DEFENSE.get(t); }
    @Override public int getEnchantmentValue() { return enchantability; }
    @Override public SoundEvent getEquipSound() { return sound; }
    @Override public Ingredient getRepairIngredient() { return repair.get(); }
    @Override public String getName() { return name; }
    @Override public float getToughness() { return toughness; }
    @Override public float getKnockbackResistance() { return knockback; }
}
