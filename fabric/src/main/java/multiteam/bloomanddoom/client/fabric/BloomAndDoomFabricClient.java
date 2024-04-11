package multiteam.bloomanddoom.client.fabric;

import multiteam.bloomanddoom.client.BloomAndDoomClient;
import net.fabricmc.api.ClientModInitializer;

public class BloomAndDoomFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BloomAndDoomClient modMain = new BloomAndDoomClient();
        modMain.init();
    }
}
