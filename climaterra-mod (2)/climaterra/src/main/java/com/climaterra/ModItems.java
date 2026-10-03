package com.climaterra;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ClimaTerra.MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ClimaTerra.MODID);


    public static final RegistryObject<Item> TERRA_HELMET = ITEMS.register("terra_helmet",
            () -> new ArmorItem(TerraArmorMaterial.TERRA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TERRA_CHESTPLATE = ITEMS.register("terra_chestplate",
            () -> new ArmorItem(TerraArmorMaterial.TERRA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TERRA_LEGGINGS = ITEMS.register("terra_leggings",
            () -> new ArmorItem(TerraArmorMaterial.TERRA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TERRA_BOOTS = ITEMS.register("terra_boots",
            () -> new ArmorItem(TerraArmorMaterial.TERRA, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("climaterra_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.climaterra"))
                    .icon(() -> new ItemStack(TERRA_HELMET.get()))
                    .displayItems((params, out) -> {
                        out.accept(TERRA_HELMET.get());
                        out.accept(TERRA_CHESTPLATE.get());
                        out.accept(TERRA_LEGGINGS.get());
                        out.accept(TERRA_BOOTS.get());
                    }).build());
}
