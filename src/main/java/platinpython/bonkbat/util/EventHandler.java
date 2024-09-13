package platinpython.bonkbat.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.util.Mth;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.FinalizeSpawnEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.item.BatItem;
import platinpython.bonkbat.util.registries.SoundRegistry;

@EventBusSubscriber(modid = BonkBat.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class EventHandler {
    private static final ImmutableSet<Class<? extends Mob>> CLASSES =
        ImmutableSet.of(Zombie.class, AbstractSkeleton.class, AbstractPiglin.class, Pillager.class, Vindicator.class);

    @SubscribeEvent
    public static void onLivingAttack(LivingIncomingDamageEvent event) {
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

    @SubscribeEvent
    public static void finalizeSpawn(FinalizeSpawnEvent event) {
        Mob mob = event.getEntity();
        if (mob.getMainHandItem().getItem() instanceof BatItem) {
            return;
        }
        if (CLASSES.stream().anyMatch(clazz -> clazz.isInstance(mob))
            && event.getSpawnType() != MobSpawnType.CONVERSION) {
            float chance;
            if (mob.getMainHandItem().isEmpty()) {
                chance = event.getLevel().getDifficulty() == Difficulty.HARD ? 0.12F : 0.07F;
            } else {
                chance = event.getLevel().getDifficulty() == Difficulty.HARD ? 0.05F : 0.02F;
            }
            if (mob.getRandom().nextFloat() <= chance) {
                mob.setItemSlot(
                    EquipmentSlot.MAINHAND,
                    BatTypes.TYPES.get(BatTypes.NAMES.get(mob.getRandom().nextInt(BatTypes.NAMES.size())))
                        .bat()
                        .get()
                        .getDefaultInstance()
                );
            }
        }
    }
}
