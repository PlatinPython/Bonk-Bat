package platinpython.bonkbat.util.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.RegistryHandler;

public class SoundRegistry {
    public static final DeferredHolder<SoundEvent, SoundEvent> BONK_SOUND = RegistryHandler.SOUNDS.register(
        "bonk", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(BonkBat.MOD_ID, "bonk"))
    );

    public static void register() {}
}
