package io.github.nitianstudio.xiuxian.data;

import io.github.nitianstudio.xiuxian.Xiuxian;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = Xiuxian.MODID, bus = EventBusSubscriber.Bus.MOD)
public class XiuxianDatagen {
    @SubscribeEvent
    public static void datagen(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput pot = gen.getPackOutput();

    }
}
