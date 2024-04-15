package multiteam.bloomanddoom.fabric;

import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.registry.BlockSetTypeRegistry;
import multiteam.bloomanddoom.registry.WoodTypeRegistry;
import net.fabricmc.api.ModInitializer;

public class BloomAndDoomFabric implements ModInitializer {
    @SuppressWarnings("UnreachableCode")
    @Override
    public void onInitialize() {
        BloomAndDoom modMain = new BloomAndDoom();
        modMain.init();
    }
}
