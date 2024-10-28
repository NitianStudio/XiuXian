package io.github.nitianstudio.xiuxian.vanilla;

import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;

public class ModPlayer {
    /**
     * {@link BreathLevel}
     * 当前练气等阶
     */
    public static final EntityDataAccessor<String> DATA_BREATH_LEVEL = SynchedEntityData.defineId(Player.class, EntityDataSerializers.STRING);
    //当前等阶练气量
    public static final EntityDataAccessor<Float> DATA_BREATH_LEVEL_EXP = SynchedEntityData.defineId(Player.class, EntityDataSerializers.FLOAT);
    /**
     * {@link BreathLevel}
     * 剩余练气等阶(计算公式为, DATA_TARGET_BREATH_LEVEL/DATA_BREATH_LEVEL)
     * 剩余等阶练气量（计算公式为， DATA_TARGET_BREATH_LEVEL_EXP/DATA_BREATH_LEVEL_EXP）
     */
    public static final EntityDataAccessor<String> DATA_TARGET_BREATH_LEVEL = SynchedEntityData.defineId(Player.class, EntityDataSerializers.STRING);
    public static final EntityDataAccessor<Float> DATA_TARGET_BREATH_LEVEL_EXP = SynchedEntityData.defineId(Player.class, EntityDataSerializers.FLOAT);

}
