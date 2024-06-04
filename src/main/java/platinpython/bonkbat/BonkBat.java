package platinpython.bonkbat;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import platinpython.bonkbat.data.DataGatherer;
import platinpython.bonkbat.util.RegistryHandler;

@Mod(BonkBat.MOD_ID)
public class BonkBat {
    public static final String MOD_ID = "bonkbat";

    public static final Logger LOGGER = LogUtils.getLogger();

    public BonkBat() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(DataGatherer::onGatherData);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(BonkBat::addItemsToTab);

        RegistryHandler.register();
    }

    public static void addItemsToTab(BuildCreativeModeTabContentsEvent event) {
        if (!event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            return;
        }
        RegistryHandler.ITEMS.getEntries()
            .forEach(item -> event.accept(item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }
}
