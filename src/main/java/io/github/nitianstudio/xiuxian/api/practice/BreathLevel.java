package io.github.nitianstudio.xiuxian.api.practice;

import io.github.nitianstudio.xiuxian.api.interfaces.IBreathLevel;
import net.minecraft.util.StringRepresentable;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

public enum BreathLevel implements StringRepresentable, IBreathLevel {//练气等级
    LAIC(generatedUpExp(BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO)),//凡人
    BREATH(generatedUpExp(new BigDecimal(100), new BigDecimal(50), BigDecimal.TEN)),//练气
    FOUNDATION(generatedUpExp(new BigDecimal(1000), new BigDecimal(500), new BigDecimal(50))),//筑基
    ELIXIR(generatedUpExp(new BigDecimal(10000), new BigDecimal(5000), new BigDecimal(500))),//金丹
    SPIRITUAL_BABY(generatedUpExp(new BigDecimal(100000), new BigDecimal(50000), new BigDecimal(5000))),//元婴
    INCARNATION(generatedUpExp(new BigDecimal(10000000), new BigDecimal(5000000), new BigDecimal(500000))),//化神
    REFINING_NULL( generatedUpExp(new BigDecimal("10000000000"), new BigDecimal("5000000000"), new BigDecimal(500000000))),//炼虚
    TRANSCENDENCY( generatedUpExp(new BigDecimal("10000000000000"), new BigDecimal("5000000000000"), new BigDecimal("500000000000"))),//合体
    MAHAYANA(generatedUpExp(new BigDecimal("100000000000000000"), new BigDecimal("50000000000000000"), new BigDecimal("5000000000000000"))),//大乘
    JUDGMENT( generatedUpExp(new BigDecimal("10000000000000000000000"), new BigDecimal("5000000000000000000000"), new BigDecimal("500000000000000000000"))),
    ;//渡劫
    public final BigDecimal earlyphase, metaphase, anaphase, complete;//升级所需灵气

    BreathLevel(BigDecimal... e_m_a_c) {
        this.earlyphase = e_m_a_c[0];
        this.metaphase = e_m_a_c[1];
        this.anaphase = e_m_a_c[2];
        this.complete = e_m_a_c[3];
    }

    public BigDecimal findPeriodExp(int period) {
        return switch (period) {
            case 1 -> this.metaphase;
            case 2 -> this.anaphase;
            case 3 -> this.complete;
            default -> this.earlyphase;
        };
    }

    public static BreathLevel getIndex(int index) {
        return Arrays.stream(BreathLevel.values())
                .filter(breathLevel -> breathLevel.index() == index)
                .findFirst()
                .orElse(BreathLevel.LAIC);
    }

    public static BigDecimal[] generatedUpExp(BigDecimal def,BigDecimal max, BigDecimal step) {
        BigDecimal[] exps = new BigDecimal[4];
        for (int i = 0;i < 4;i++) {
            exps[i] = def.add(max.subtract(step.multiply(BigDecimal.valueOf(i))).multiply(BigDecimal.valueOf(i)))
                    .add(max.subtract(step.multiply(BigDecimal.valueOf(i - 1))).multiply(BigDecimal.valueOf(Math.max(i - 1, 0))))
                    .add(max.subtract(step.multiply(BigDecimal.valueOf(i - 2))).multiply(BigDecimal.valueOf(Math.max(i - 2, 0))));
        }
        return exps;
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
