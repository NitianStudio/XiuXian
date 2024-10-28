package io.github.nitianstudio.xiuxian.api.pellet;

import net.minecraft.world.item.ItemStack;

public interface IPellet {
    double toxicity(ItemStack stack);//毒性/抗药性
    double effect(ItemStack stack);//效果
    int level( ItemStack stack);//仙 天 地 玄 黄 凡 凡0~9  黄10~19 玄 20~29 地 30~39 天 40~49 仙 50~59
    default double multiplying(ItemStack stack) {
        if (level(stack) > 59) {
            return 11;
        } else if (level(stack) >= 50) {
            return 6;
        } else if (level(stack) >= 40) {
            return 3;
        } else if (level(stack) >= 30) {
            return 2;
        } else if (level(stack) >= 20) {
            return 1.5;
        } else if (level(stack) >= 10) {
            return 1.25;
        } else {
            return 1.125;
        }
    }
}
