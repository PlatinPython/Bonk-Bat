package platinpython.bonkbat.util.registries;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import platinpython.bonkbat.item.BatItem;
import platinpython.bonkbat.util.BatTypes;
import platinpython.bonkbat.util.RegistryHandler;

public class ItemRegistry {
    public static void register() {
        BatTypes.NAMES.forEach(name -> BatTypes.TYPES.put(name, new BatTypes.Type(() -> {
            String suffix = "_wood";
            if (name.equals("crimson") || name.equals("warped")) {
                suffix = "_hyphae";
            }
            return BuiltInRegistries.ITEM.get(ResourceLocation.withDefaultNamespace("stripped_" + name + suffix))
                .orElseThrow()
                .value();
        }, RegistryHandler.ITEMS.registerItem(
            name + "_bat", BatItem::new, new Item.Properties().stacksTo(1).equippableUnswappable(EquipmentSlot.HEAD)
        ))));
    }
}
