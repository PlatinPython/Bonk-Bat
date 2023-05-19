package platinpython.bonkbat.util;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.registries.ItemRegistry;
import platinpython.bonkbat.util.registries.SoundRegistry;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BonkBat.MOD_ID);

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
                                                                                      BonkBat.MOD_ID
    );

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());

        ItemRegistry.register();
        SoundRegistry.register();
    }
}
