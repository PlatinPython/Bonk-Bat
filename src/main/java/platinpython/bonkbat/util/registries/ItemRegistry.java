package platinpython.bonkbat.util.registries;

import net.minecraftforge.registries.RegistryObject;
import platinpython.bonkbat.item.BatItem;
import platinpython.bonkbat.util.RegistryHandler;

public class ItemRegistry {
    public static final RegistryObject<BatItem> OAK_BAT = RegistryHandler.ITEMS.register("oak_bat", BatItem::new);

    public static void register() {
    }
}
