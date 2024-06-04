package platinpython.bonkbat.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.BatTypes;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BonkBat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        BatTypes.TYPES.forEach((name, type) -> {
            String suffix = "_log";
            if (name.equals("crimson") || name.equals("warped")) {
                suffix = "_stem";
            }
            singleTexture(
                name + "_bat", modLoc(ITEM_FOLDER + "/bat"), "0", mcLoc(BLOCK_FOLDER + "/stripped_" + name + suffix)
            );
        });
    }
}
