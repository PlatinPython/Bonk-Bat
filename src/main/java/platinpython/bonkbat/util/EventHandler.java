package platinpython.bonkbat.util;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.item.BatItem;
import platinpython.bonkbat.util.registries.SoundRegistry;

@Mod.EventBusSubscriber(modid = BonkBat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {
    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        if (!(event.getSource().getEntity() instanceof LivingEntity attacker)) {
            return;
        }
        if (!(attacker.getMainHandItem().getItem() instanceof BatItem)) {
            return;
        }
        attacker.level()
            .playSound(
                null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(),
                SoundRegistry.BONK_SOUND.get(), attacker.getSoundSource(), 1F, 1F
            );
        event.getEntity()
            .knockback(
                0.4, Mth.sin(attacker.getYRot() * Mth.DEG_TO_RAD), -Mth.cos(attacker.getYRot() * Mth.DEG_TO_RAD)
            );
        event.getEntity().hurtMarked = true;
        event.setCanceled(true);
    }
}
