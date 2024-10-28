package io.github.nitianstudio.xiuxian.constants.item;

import io.github.nitianstudio.xiuxian.constants.abstracts.AbstractPellet;
import net.minecraft.world.item.ItemStack;

public class GatheringAuraPellet extends AbstractPellet {
    public GatheringAuraPellet(Properties properties) {
        super(properties);
    }

    @Override
    public double toxicity(ItemStack stack) {
        return 0.1 * multiplying(stack);
    }

    @Override
    public double effect(ItemStack stack) {
        return 4 * multiplying(stack);
    }


}
