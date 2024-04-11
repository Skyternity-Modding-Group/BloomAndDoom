package multiteam.bloomanddoom.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import net.minecraft.client.Minecraft;

public class BloomAndDoomClient {
    public void init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(this::clientSetup);
    }

    private void clientSetup(Minecraft minecraft) {
        // Do client stuff
    }
}
