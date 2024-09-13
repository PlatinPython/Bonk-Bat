package platinpython.bonkbat.util;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.registries.ItemRegistry;
import platinpython.bonkbat.util.registries.SoundRegistry;

public class RegistryHandler {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BonkBat.MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUNDS =
        DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, BonkBat.MOD_ID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
        SOUNDS.register(bus);

        ItemRegistry.register();
        SoundRegistry.register();
    }
}
