package io.github.nitianstudio.xiuxian.constants.init;

import io.github.nitianstudio.xiuxian.Xiuxian;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

public class ModRegistry {
    static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Xiuxian.MODID);
    static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Xiuxian.MODID);
    public static void register(IEventBus eventBus) {
        ModComponents.init();
        ModPellets.init();
        COMPONENTS.register(eventBus);
        ITEMS.register(eventBus);

    }

    public static Collection<DeferredHolder<Item, ? extends Item>> items() {
        return ITEMS.getEntries();
    }

    public static Collection<DeferredHolder<DataComponentType<?>, ? extends DataComponentType<?>>> components() {
        return COMPONENTS.getEntries();
    }
}
