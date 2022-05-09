package com.pentad.rtborg.tutorialmod.util;

import com.pentad.rtborg.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        makeBow(ModItems.KAUPENBOW.get());
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, new ResourceLocation("pull"), (pItemStack, pClientLevel, pLivingEntity, pId) -> {
            if (pLivingEntity == null) {
                return 0.0F;
            } else {
                return pLivingEntity.getUseItem() != pItemStack ?
                        0.0F :
                        (float) (pItemStack.getUseDuration() - pLivingEntity.getUseItemRemainingTicks()) / 20.0F;
            }
        });

        ItemProperties.register(item, new ResourceLocation("pulling"), (pItemStack, pClientLevel, pLivingEntity, pId) -> {
            return pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F;
        });
    }
}
