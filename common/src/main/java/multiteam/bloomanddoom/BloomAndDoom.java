package multiteam.bloomanddoom;

import dev.architectury.event.events.common.LifecycleEvent;
import multiteam.bloomanddoom.main.EventHandler;
import multiteam.bloomanddoom.main.Registration;
import multiteam.bloomanddoom.main.worldgen.biome.surface.ModSurfaceRules;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.SurfaceRuleManager;

import java.util.logging.ErrorManager;

public class BloomAndDoom {
    public static final Logger LOGGER = LoggerFactory.getLogger("BloomAndDoom");

    public static ResourceLocation res(String path) {
        return new ResourceLocation(References.MOD_ID, path);
    }

    private void commonSetup() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, References.MOD_ID, ModSurfaceRules.makeRules());
    }

    public void init() {
        // Mod initialization
        Registration.register();
        EventHandler.init();

        LifecycleEvent.SETUP.register(this::commonSetup);
    }
}
