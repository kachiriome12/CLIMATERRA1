package com.climaterra;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    private static final ForgeConfigSpec.Builder B = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue BLOCK_RAIN = B
            .comment("Se true, nunca chove nem tem tempestade no Overworld")
            .define("blockRain", true);

    public static final ForgeConfigSpec.IntValue EXTRA_MINUTES = B
            .comment("Minutos extras na duracao do dia (vanilla = 20 min). 10 => dia de 30 min. 0 = vanilla")
            .defineInRange("extraMinutes", 10, 0, 240);

    public static final ForgeConfigSpec SPEC = B.build();
}
