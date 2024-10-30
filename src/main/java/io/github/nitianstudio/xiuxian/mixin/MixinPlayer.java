package io.github.nitianstudio.xiuxian.mixin;

import io.github.nitianstudio.xiuxian.api.interfaces.IPlayer;
import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.network.syncher.SynchedEntityData.*;

@Mixin(Player.class)
@Debug(export = true)
public abstract class MixinPlayer extends Entity implements IPlayer {
    public MixinPlayer(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "defineSynchedData", at = @At("RETURN"))
    private void initPellet(Builder builder, CallbackInfo ci) {
        builder.define(DATA_BREATH_LEVEL, BreathLevel.LAIC.getSerializedName());
        builder.define(DATA_BREATH_PERIOD, 0);// min 0 max 3
        builder.define(DATA_TARGET_BREATH_LEVEL, BreathLevel.LAIC.getSerializedName());
        builder.define(DATA_BREATH_LEVEL_EXP, "0.0000000000");
        builder.define(DATA_TARGET_BREATH_PERIOD, 0);// min 0 max 3
        builder.define(DATA_TARGET_BREATH_LEVEL_EXP, "0.0000000000");
    }

    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void saveNbt(CompoundTag compound, CallbackInfo ci) {
        compound.putString("breath_level_exp", entityData.get(DATA_BREATH_LEVEL_EXP));
        compound.putString("breath_target_level_exp", entityData.get(DATA_TARGET_BREATH_LEVEL_EXP));
        compound.putString("breath_level", entityData.get(DATA_BREATH_LEVEL));
        compound.putString("breath_target_level", entityData.get(DATA_TARGET_BREATH_LEVEL));
        compound.putInt("breath_period", entityData.get(DATA_BREATH_PERIOD));
        compound.putInt("breath_target_period", entityData.get(DATA_TARGET_BREATH_PERIOD));
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void readNbt(CompoundTag compound, CallbackInfo ci) {
        entityData.set(DATA_BREATH_LEVEL_EXP, compound.getString("breath_level_exp"));
        entityData.set(DATA_TARGET_BREATH_LEVEL_EXP, compound.getString("breath_target_level_exp"));
        entityData.set(DATA_BREATH_LEVEL, compound.getString("breath_level"));
        entityData.set(DATA_TARGET_BREATH_LEVEL, compound.getString("breath_target_level"));
        entityData.set(DATA_BREATH_PERIOD, compound.getInt("breath_period"));
        entityData.set(DATA_TARGET_BREATH_PERIOD, compound.getInt("breath_target_period"));
    }
}
