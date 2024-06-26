package com.mitchej123.hodgepodge.mixins.late.gravisuite;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

import org.spongepowered.asm.mixin.Mixin;

import com.brandon3055.brandonscore.common.lib.References;
import com.brandon3055.draconicevolution.common.utills.IConfigurableItem;
import com.brandon3055.draconicevolution.common.utills.ItemConfigField;
import com.mitchej123.hodgepodge.mixins.hooks.AdvancedItemConfigField;
import com.mitchej123.hodgepodge.mixins.interfaces.DEConfigurableExt;

import gravisuite.ItemAdvChainsaw;

@Mixin(ItemAdvChainsaw.class)
public class MixinGraviAdvChainsawDEIntegration implements DEConfigurableExt, IConfigurableItem {

    @Override
    public List<ItemConfigField> getFields(ItemStack stack, int slot) {
        List<ItemConfigField> fields = new ArrayList<>();
        // So funny thing, Gravisuite has the boolean logic reversed. So I had to use the enum system.
        fields.add(
                new AdvancedItemConfigField(References.INT_ID, slot, "toolMode", "gravisuite.Shear")
                        .representAsEnum(new String[] { "ic2.on", "ic2.off" }).readFromItem(stack, 0));
        return fields;
    }

    @Override
    public boolean hasProfiles() {
        return false;
    }
}
