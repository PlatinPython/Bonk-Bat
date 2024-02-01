package platinpython.bonkbat.util.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.RegistryObject;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.RegistryHandler;

public class SoundRegistry {
    public static final RegistryObject<SoundEvent> BONK_SOUND = RegistryHandler.SOUNDS.register(
        "bonk", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(BonkBat.MOD_ID, "bonk"))
    );

    public static void register() {
    }
}
