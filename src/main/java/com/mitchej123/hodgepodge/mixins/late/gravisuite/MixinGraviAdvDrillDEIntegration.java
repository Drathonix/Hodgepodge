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

import gravisuite.ItemAdvDDrill;

@Mixin(ItemAdvDDrill.class)
public class MixinGraviAdvDrillDEIntegration implements DEConfigurableExt, IConfigurableItem {

    @Override
    public List<ItemConfigField> getFields(ItemStack stack, int slot) {
        List<ItemConfigField> fields = new ArrayList<>();
        fields.add(
                new AdvancedItemConfigField(References.INT_ID, slot, "toolMode", "gravisuite.Drill")
                        .representAsEnum(
                                new String[] { "gravisuite.normalPower", "gravisuite.lowPower",
                                        "gravisuite.ultraLowPower", "gravisuite.bigHolePower" })
                        .readFromItem(stack, 0));
        return fields;
    }

    @Override
    public boolean hasProfiles() {
        return false;
    }
}
