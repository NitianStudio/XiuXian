package io.github.nitianstudio.xiuxian.api.interfaces;

import net.minecraft.world.entity.player.Player;

public interface IPlayer {
    private Player self() {
        return (Player) this;
    }
}
