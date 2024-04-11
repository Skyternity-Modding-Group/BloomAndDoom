package multiteam.bloomanddoom.fabric;

import multiteam.bloomanddoom.BloomAndDoom;
import net.fabricmc.api.ModInitializer;

public class BloomAndDoomFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        BloomAndDoom modMain = new BloomAndDoom();
        modMain.init();
    }
}
