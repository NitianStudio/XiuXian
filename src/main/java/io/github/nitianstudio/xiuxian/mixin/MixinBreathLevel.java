package io.github.nitianstudio.xiuxian.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BreathLevel.class)
@Debug(export = true)
public class MixinBreathLevel {

    @Unique
    private int xiuXian$ordinal;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(String name, int ordinal, float[] e_m_a_c, CallbackInfo ci) {
        xiuXian$ordinal = ordinal;
    }

    @ModifyReturnValue(method = "index", at = @At("RETURN"))
    private int modifyReturnValue(int original) {
        return xiuXian$ordinal;
    }
}
