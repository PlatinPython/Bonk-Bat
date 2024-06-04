package platinpython.bonkbat.util.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import platinpython.bonkbat.item.BatItem;
import platinpython.bonkbat.util.BatTypes;
import platinpython.bonkbat.util.RegistryHandler;

import java.util.Objects;

public class ItemRegistry {
    public static void register() {
        BatTypes.NAMES.forEach(name -> BatTypes.TYPES.put(name, new BatTypes.Type(() -> {
            String suffix = "_wood";
            if (name.equals("crimson") || name.equals("warped")) {
                suffix = "_hyphae";
            }
            return Objects
                .requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation("stripped_" + name + suffix)));
        }, RegistryHandler.ITEMS.register(name + "_bat", BatItem::new))));
    }
}
