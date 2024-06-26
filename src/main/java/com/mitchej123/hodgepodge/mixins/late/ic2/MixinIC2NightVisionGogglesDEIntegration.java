package com.mitchej123.hodgepodge.mixins.late.ic2;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;

import com.brandon3055.brandonscore.common.lib.References;
import com.brandon3055.draconicevolution.common.utills.IConfigurableItem;
import com.brandon3055.draconicevolution.common.utills.ItemConfigField;
import com.mitchej123.hodgepodge.mixins.interfaces.DEConfigurableExt;

import ic2.core.item.armor.ItemArmorNightvisionGoggles;

@Mixin(ItemArmorNightvisionGoggles.class)
public class MixinIC2NightVisionGogglesDEIntegration implements DEConfigurableExt, IConfigurableItem {

    @Override
    public List<ItemConfigField> getFields(ItemStack stack, int slot) {
        List<ItemConfigField> fields = new ArrayList<>();
        fields.add(new ItemConfigField(References.BOOLEAN_ID, slot, "active").readFromItem(stack, false));
        return fields;
    }

    @Override
    public boolean hasProfiles() {
        return false;
    }
}
