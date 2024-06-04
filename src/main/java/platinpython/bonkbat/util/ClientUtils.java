package platinpython.bonkbat.util;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import platinpython.bonkbat.BonkBat;

@Mod.EventBusSubscriber(modid = BonkBat.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientUtils {
    @SubscribeEvent
    public static void addItemsToTab(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() != CreativeModeTabs.COMBAT) {
            return;
        }
        RegistryHandler.ITEMS.getEntries()
            .forEach(item -> event.accept(item, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS));
    }
}
