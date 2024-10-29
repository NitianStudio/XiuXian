package io.github.nitianstudio.xiuxian.api.practice;

import io.github.nitianstudio.xiuxian.api.interfaces.IBreathLevel;
import net.minecraft.util.StringRepresentable;

public enum BreathLevel implements StringRepresentable, IBreathLevel {//练气等级
    LAIC(generatedUpExp(1F, 0F, 0F)),//凡人
    BREATH(generatedUpExp(100F, 30F, 10F)),//练气
    FOUNDATION(generatedUpExp(400F, 200F, 50F)),//筑基
    ELIXIR(generatedUpExp(3000F, 500F, 100F)),//金丹
    SPIRITUAL_BABY(generatedUpExp(8000F, 2000F, 400F)),//元婴
    INCARNATION(generatedUpExp(40000F, 20000F, 1200F)),//化神
    REFINING_NULL( generatedUpExp(300000, 50000F, 20000F)),//炼虚
    TRANSCENDENCY( generatedUpExp(900000F, 400000F, 60000F)),//合体
    MAHAYANA(generatedUpExp(10000000F, 5000000F, 100000F)),//大乘
    JUDGMENT( generatedUpExp(100000000000F, 400000000F, 4000000F)),
    ;//渡劫
    public final float earlyphase, metaphase, anaphase, complete;//升级所需灵气

    BreathLevel(float... e_m_a_c) {
        this.earlyphase = e_m_a_c[0];
        this.metaphase = e_m_a_c[1];
        this.anaphase = e_m_a_c[2];
        this.complete = e_m_a_c[3];
    }

    public static BreathLevel getIndex(int index) {
        return switch (index) {
            case 1 -> BREATH;
            case 2 -> FOUNDATION;
            case 3 -> ELIXIR;
            case 4 -> SPIRITUAL_BABY;
            case 5 -> INCARNATION;
            case 6 -> REFINING_NULL;
            case 7 -> TRANSCENDENCY;
            case 8 -> MAHAYANA;
            case 9 -> JUDGMENT;
            default -> LAIC;
        };
    }

    public static float[] generatedUpExp(float def, float max, float step) {
        float[] exps = new float[4];
        for (int i = 0;i < 4;i++) {
            exps[i] = def +
                    (max - step * i) * i +
                    (max - step * (i - 1)) * Math.max(i - 1, 0) +
                    (max - step * (i - 2)) * Math.max(i - 2, 0);
        }
        return exps;
    }


    @Override
    public String getSerializedName() {
        return name();
    }

    @Override
    public int index() {
        return 0;
    }
}
