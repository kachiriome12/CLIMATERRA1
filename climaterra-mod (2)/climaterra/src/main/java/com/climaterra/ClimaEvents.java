package com.climaterra;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

public class ClimaEvents {
    private long prevDayTime = 0;
    private double acc = 0;

    @SubscribeEvent
    public void onLevelTick(TickEvent.LevelTickEvent e) {
        if (e.side != LogicalSide.SERVER || !(e.level instanceof ServerLevel level)) return;
        if (level.dimension() != Level.OVERWORLD) return;

        if (e.phase == TickEvent.Phase.START) {
            prevDayTime = level.getDayTime();
            return;
        }

        // ---- Sem chuva ----
        if (Config.BLOCK_RAIN.get() && (level.isRaining() || level.isThundering())) {
            // clearTime alto (7 dias de jogo) impede o clima de voltar a chover
            level.setWeatherParameters(168000, 0, false, false);
        }

        // ---- Dia mais longo ----
        int extra = Config.EXTRA_MINUTES.get();
        if (extra > 0 && level.getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
            long delta = level.getDayTime() - prevDayTime;
            if (delta == 1) { // so mexe no avanço normal; ignora dormir / /time set
                acc += 20.0 / (20.0 + extra);
                long adv = (long) acc;
                acc -= adv;
                level.setDayTime(prevDayTime + adv);
            }
        }
    }
}
