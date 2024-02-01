package platinpython.bonkbat.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.registries.ItemRegistry;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BonkBat.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        singleTexture(
            ItemRegistry.OAK_BAT.getId().getPath(), modLoc(ITEM_FOLDER + "/bat"), "0",
            mcLoc(BLOCK_FOLDER + "/stripped_oak_log")
        );
    }
}
