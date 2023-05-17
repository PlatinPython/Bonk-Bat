package platinpython.bonkbat.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.registries.ItemRegistry;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, BonkBat.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ItemRegistry.OAK_BAT.get(), "Oak Bat");
    }
}
