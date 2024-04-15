package multiteam.bloomanddoom.registry.forge;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;

import static multiteam.bloomanddoom.registry.WoodTypeRegistry.*;

public class WoodTypeRegistryImpl {
    public static void registerWoodTypes() {
        for (WoodType customWoodType : getCustomWoodTypes()) {
            WoodType.register(customWoodType);
        }

        EnvExecutor.runInEnv(Env.CLIENT, () -> () -> {
            ClientLifecycleEvent.CLIENT_STARTED.register(client -> {
                for (WoodType customWoodType : getCustomWoodTypes()) {
                    Sheets.addWoodType(customWoodType);
                }
            });
        });
    }
}
