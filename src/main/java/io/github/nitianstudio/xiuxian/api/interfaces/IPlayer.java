package io.github.nitianstudio.xiuxian.api.interfaces;

import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;

import java.math.BigDecimal;

public interface IPlayer {
    /**
     * {@link BreathLevel}
     *
     *
     *
     * 当前练气等阶
     * 当前灵气量
     * <p>
     * 剩余练气等阶(计算公式为,
     * {@code {@link IPlayer#DATA_TARGET_BREATH_LEVEL} / {@link IPlayer#DATA_BREATH_LEVEL}}
     * </p>
     * <p>
     * 剩余等阶练气量（计算公式为，
     * {@code {@link IPlayer#DATA_TARGET_BREATH_LEVEL_EXP} / {@link IPlayer#DATA_BREATH_LEVEL_EXP}}
     * </p>
     */
    EntityDataAccessor<String> DATA_BREATH_LEVEL = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.STRING);
    EntityDataAccessor<Integer> DATA_BREATH_PERIOD = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.INT);
    EntityDataAccessor<String> DATA_BREATH_LEVEL_EXP = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.STRING);
    EntityDataAccessor<String> DATA_TARGET_BREATH_LEVEL = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.STRING);
    EntityDataAccessor<Integer> DATA_TARGET_BREATH_PERIOD = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.INT);
    EntityDataAccessor<String> DATA_TARGET_BREATH_LEVEL_EXP = SynchedEntityData
            .defineId(Player.class, EntityDataSerializers.STRING);

    private Player self() {
        return (Player) this;
    }
    default BreathLevel getBreathLevel() {
        return BreathLevel.valueOf(self().getEntityData().get(DATA_BREATH_LEVEL));
    }
    default void setBreathLevel(BreathLevel breathLevel) {
        self().getEntityData().set(DATA_BREATH_LEVEL, breathLevel.name());
    }

    default BigDecimal getBreathLevelExp() {
        return new BigDecimal(self().getEntityData().get(DATA_BREATH_LEVEL_EXP));
    }
    default void setBreathLevelExp(BigDecimal breathLevelExp) {
        self().getEntityData().set(DATA_BREATH_LEVEL_EXP, breathLevelExp.toString());
    }

    default BreathLevel getTargetBreathLevel() {
        return BreathLevel.valueOf(self().getEntityData().get(DATA_TARGET_BREATH_LEVEL));
    }

    default void setTargetBreathLevel(BreathLevel breathLevel) {
        self().getEntityData().set(DATA_TARGET_BREATH_LEVEL, breathLevel.name());
    }

    default BigDecimal getTargetBreathLevelExp() {
        return new BigDecimal(self().getEntityData().get(DATA_TARGET_BREATH_LEVEL_EXP));
    }

    default void setTargetBreathLevelExp(BigDecimal breathLevelExp) {
        self().getEntityData().set(DATA_TARGET_BREATH_LEVEL_EXP, breathLevelExp.toString());
    }

    default int getBreathPeriod() {
        return self().getEntityData().get(DATA_BREATH_PERIOD);
    }

    default void setBreathPeriod(int breathPeriod) {
        self().getEntityData().set(DATA_BREATH_PERIOD, breathPeriod);
    }

    default int getTargetBreathPeriod() {
        return self().getEntityData().get(DATA_TARGET_BREATH_PERIOD);
    }

    default void setTargetBreathPeriod(int breathPeriod) {
        self().getEntityData().set(DATA_TARGET_BREATH_PERIOD, breathPeriod);
    }

    default void unleashSpellsByBreathLevel(BigDecimal exp) {
        setBreathLevelExp(getBreathLevelExp().add(exp));
    }

}
