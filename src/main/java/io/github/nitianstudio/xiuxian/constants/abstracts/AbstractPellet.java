package io.github.nitianstudio.xiuxian.constants.abstracts;

import io.github.nitianstudio.xiuxian.api.pellet.IPellet;
import io.github.nitianstudio.xiuxian.constants.init.ModComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractPellet extends Item implements IPellet {

    public AbstractPellet(Properties properties) {
        super(properties);
    }

    @Override
    public int level(ItemStack stack) {
        return stack.getOrDefault(ModComponents.PELLET_LEVEL, 0);
    }
}
