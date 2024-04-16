package multiteam.bloomanddoom;

import dev.architectury.event.events.common.LifecycleEvent;
import dev.architectury.hooks.item.tool.AxeItemHooks;
import multiteam.bloomanddoom.block.ModBlockSetType;
import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.block.wood.ModWoodType;
import multiteam.bloomanddoom.init.EventHandler;
import multiteam.bloomanddoom.init.References;
import multiteam.bloomanddoom.item.ModItems;
import multiteam.bloomanddoom.registry.BlockSetTypeRegistry;
import multiteam.bloomanddoom.registry.Registration;
import multiteam.bloomanddoom.registry.WoodTypeRegistry;
import multiteam.bloomanddoom.world.gen.biome.surface.ModSurfaceRules;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.SurfaceRuleManager;

public class BloomAndDoom {
    public static final Logger LOGGER = LoggerFactory.getLogger("BloomAndDoom");

    public static ResourceLocation res(String path) {
        return new ResourceLocation(References.MOD_ID, path);
    }

    private void commonSetup() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, References.MOD_ID, ModSurfaceRules.makeRules());
        ModBlocks.registerStrippables();
        ModItems.registerFuels();
    }

    @SuppressWarnings("UnreachableCode")
    public void init() {
        // Mod initialization
        Registration.register();
        EventHandler.init();

        BlockSetTypeRegistry.register(ModBlockSetType.STEM);
        WoodTypeRegistry.register(ModWoodType.STEM);

        LifecycleEvent.SETUP.register(this::commonSetup);

        BlockSetTypeRegistry.registerBlockSetTypes();
        WoodTypeRegistry.registerWoodTypes(); // IntelliJ WHY??? This is just fine! C'mon!

        LOGGER.info("Bloom and Doom Initialized");
    }
}
