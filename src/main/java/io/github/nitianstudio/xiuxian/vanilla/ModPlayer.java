package io.github.nitianstudio.xiuxian.vanilla;

import io.github.nitianstudio.xiuxian.api.practice.BreathLevel;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.player.Player;

public class ModPlayer {
    /**
     * {@link BreathLevel}
     */
    public static final EntityDataAccessor<String> BREATH_LEVEL = SynchedEntityData.defineId(Player.class, EntityDataSerializers.STRING);
}
