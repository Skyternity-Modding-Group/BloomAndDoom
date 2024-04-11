package multiteam.bloomanddoom;

import dev.architectury.event.events.common.LifecycleEvent;
import multiteam.bloomanddoom.main.EventHandler;
import multiteam.bloomanddoom.main.Registration;
import net.minecraft.resources.ResourceLocation;

public class BloomAndDoom {
    public static final String MOD_ID = "bloom_and_doom";

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    private void commonSetup() {
        // Do client/server stuff here
    }

    public void init() {
        // Mod initialization
        Registration.register();
        EventHandler.init();

        LifecycleEvent.SETUP.register(this::commonSetup);
    }
}
