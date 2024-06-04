package platinpython.bonkbat.util;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.item.Item;
import platinpython.bonkbat.item.BatItem;

import java.util.HashMap;
import java.util.function.Supplier;

public class BatTypes {
    public static final ImmutableSet<String> NAMES = ImmutableSet
        .of("oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "crimson", "warped", "mangrove", "cherry");
    public static final HashMap<String, Type> TYPES = new HashMap<>();

    public record Type(Supplier<Item> wood, Supplier<BatItem> bat) {}
}
