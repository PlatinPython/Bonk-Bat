package platinpython.bonkbat.item;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import platinpython.bonkbat.util.registries.SoundRegistry;

public class BatItem extends Item {
    public BatItem() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (!(entity instanceof LivingEntity livingEntity)) {
            return false;
        }
        player.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundRegistry.BONK_SOUND.get(),
                               player.getSoundSource(), 1F, 1F
        );
        livingEntity.knockback(0.4, Mth.sin(player.getYRot() * Mth.DEG_TO_RAD),
                               -Mth.cos(player.getYRot() * Mth.DEG_TO_RAD)
        );
        return true;
    }
}
