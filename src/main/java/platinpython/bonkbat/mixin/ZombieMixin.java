package platinpython.bonkbat.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import platinpython.bonkbat.util.BatTypes;

import java.util.function.Supplier;

@Mixin(Zombie.class)
public class ZombieMixin extends Monster {
    public ZombieMixin(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @ModifyVariable(
        method = "aiStep()V",
        at = @At("STORE"),
        slice = @Slice(
            from = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z"),
            to = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/monster/Zombie;igniteForSeconds(F)V")
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
