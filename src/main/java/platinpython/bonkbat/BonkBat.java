package platinpython.bonkbat;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;
import platinpython.bonkbat.data.DataGatherer;
import platinpython.bonkbat.util.RegistryHandler;

@Mod(BonkBat.MOD_ID)
public class BonkBat {
    public static final String MOD_ID = "bonkbat";

    public static final Logger LOGGER = LogUtils.getLogger();

    public BonkBat(IEventBus bus) {
        bus.addListener(DataGatherer::onGatherData);
        bus.addListener(BonkBat::addItemsToTab);

        RegistryHandler.register(bus);
    }

    public static void addItemsToTab(BuildCreativeModeTabContentsEvent event) {
        if (!event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            return;
        }
        RegistryHandler.ITEMS.getEntries()
            .forEach(item -> event.accept(item.value(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }
}
