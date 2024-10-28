package io.github.nitianstudio.xiuxian.constants.init;

import io.github.nitianstudio.xiuxian.api.pellet.IPellet;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.function.Supplier;

import static io.github.nitianstudio.xiuxian.constants.init.ModRegistry.ITEMS;

public enum ModPellets implements Supplier<IPellet>, ItemLike {
    ;
    private final DeferredHolder<Item,? extends IPellet> item;

    <T extends Item & IPellet> ModPellets(T item) {
        this.item = ITEMS.register(this.name(), () -> item);
    }

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public IPellet get() {
        return item.get();
    }

    @Override
    public Item asItem() {
        return item.get().asItem();
    }

    public static void init() {}
}
