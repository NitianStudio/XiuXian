package io.github.nitianstudio.xiuxian.mixin;

import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BreathLevel.class)
public class MixinBreathLevel {
    @Final @Mutable @Shadow
    private static BreathLevel[] $VALUES;

    @Unique
    private int xiuXian$ordinal;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(String name, int ordinal, float[] e_m_a_c, CallbackInfo ci) {
        xiuXian$ordinal = ordinal;
    }

    @Inject(method = "index", at = @At("RETURN"), cancellable = true)
    private void index(CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(xiuXian$ordinal);
    }
}
