package platinpython.bonkbat.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import org.codehaus.plexus.util.StringUtils;
import platinpython.bonkbat.BonkBat;
import platinpython.bonkbat.util.BatTypes;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
        super(output, BonkBat.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        BatTypes.TYPES.forEach(
            (name, type) -> addItem(type.bat(), StringUtils.capitaliseAllWords(name.replace('_', ' ')) + " Bat")
        );
    }
}
