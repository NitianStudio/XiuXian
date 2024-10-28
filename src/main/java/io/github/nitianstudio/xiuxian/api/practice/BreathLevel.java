package io.github.nitianstudio.xiuxian.api.practice;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum BreathLevel implements StringRepresentable {//练气等级
    LAIC,//凡人
    BREATH,//练气
    FOUNDATION,//筑基
    ELIXIR,//金丹
    SPIRITUAL_BABY,//元婴
    INCARNATION,//化神
    REFINING_NULL,//炼虚
    TRANSCENDENCY,//合体
    MAHAYANA,//大乘
    JUDGMENT,
    ;//渡劫

    @Override
    public String getSerializedName() {
        return name();
    }
}
