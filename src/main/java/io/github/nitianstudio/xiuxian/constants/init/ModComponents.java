package io.github.nitianstudio.xiuxian.constants.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;

import static io.github.nitianstudio.xiuxian.constants.init.ModRegistry.COMPONENTS;

public class ModComponents {
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> PELLET_LEVEL = register("pellet_level", Codec.INT, ByteBufCodecs.INT);

    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name, PrimitiveCodec<T> codec, StreamCodec<ByteBuf, T> streamCodec) {
        return COMPONENTS.registerComponentType(name, builder -> builder.persistent(codec).networkSynchronized(streamCodec));
    }

    public static void init(){}
}
