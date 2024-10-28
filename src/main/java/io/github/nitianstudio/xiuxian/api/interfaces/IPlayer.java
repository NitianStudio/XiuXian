package io.github.nitianstudio.xiuxian.api.interfaces;

import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;

public interface IPlayer {
    /**
     * {@link BreathLevel}
     * 当前练气等阶
     * 当前灵气量
     * 剩余练气等阶(计算公式为,
     * {@code {@link IPlayer#DATA_TARGET_BREATH_LEVEL} / {@link IPlayer#DATA_BREATH_LEVEL}}
     * 剩余等阶练气量（计算公式为，
     * {@code {@link IPlayer#DATA_TARGET_BREATH_LEVEL_EXP} / {@link IPlayer#DATA_BREATH_LEVEL_EXP}}
     */
    EntityDataAccessor<String> DATA_BREATH_LEVEL = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.STRING);
    EntityDataAccessor<Float> DATA_BREATH_LEVEL_EXP = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.FLOAT);
    EntityDataAccessor<String> DATA_TARGET_BREATH_LEVEL = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.STRING);
    EntityDataAccessor<Float> DATA_TARGET_BREATH_LEVEL_EXP = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.FLOAT);

    private Player self() {
        return (Player) this;
    }
    default void getBreathLevel() {

    }
}
