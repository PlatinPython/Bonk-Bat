package platinpython.bonkbat;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import platinpython.bonkbat.data.DataGatherer;
import platinpython.bonkbat.util.RegistryHandler;

@Mod(BonkBat.MOD_ID)
public class BonkBat {
    public static final String MOD_ID = "bonkbat";

    public static final Logger LOGGER = LogUtils.getLogger();

    public BonkBat() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(DataGatherer::onGatherData);

        RegistryHandler.register();
    }
}
