package platinpython.bonkbat.mixin;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import platinpython.bonkbat.util.BatTypes;

import java.util.concurrent.ThreadLocalRandom;

@Mixin(Mob.class)
public class MobMixin {
    @Inject(method = "getEquipmentForSlot", at = @At("HEAD"), cancellable = true)
    private static void addBonkBats(EquipmentSlot slot, int chance, CallbackInfoReturnable<@Nullable Item> cir) {
        if (slot == EquipmentSlot.HEAD && ThreadLocalRandom.current().nextFloat() <= 0.1) {
            cir.setReturnValue(
                BatTypes.TYPES.get(BatTypes.NAMES.get(ThreadLocalRandom.current().nextInt(BatTypes.NAMES.size())))
                    .bat()
                    .get()
            );
        }
    }
}
