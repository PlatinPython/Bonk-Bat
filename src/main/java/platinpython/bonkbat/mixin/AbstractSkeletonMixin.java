package platinpython.bonkbat.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import platinpython.bonkbat.util.BatTypes;

import java.util.function.Supplier;

@Mixin(AbstractSkeleton.class)
public abstract class AbstractSkeletonMixin extends Monster implements RangedAttackMob {
    protected AbstractSkeletonMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyVariable(
        method = "aiStep()V",
        at = @At("STORE"),
        slice = @Slice(
            from = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z"),
            to = @At(
                value = "INVOKE",
                target = "Lnet/minecraft/world/entity/monster/AbstractSkeleton;setSecondsOnFire(I)V"
            )
        )
    )
    private boolean bonkBatsUnblockSun(boolean flag) {
        return flag || BatTypes.TYPES.values()
            .stream()
            .map(BatTypes.Type::bat)
            .map(Supplier::get)
            .anyMatch(bat -> this.getItemBySlot(EquipmentSlot.HEAD).is(bat));
    }
}
