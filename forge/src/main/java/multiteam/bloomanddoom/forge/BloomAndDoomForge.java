package multiteam.bloomanddoom.forge;

import dev.architectury.platform.forge.EventBuses;
import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.init.References;
import multiteam.bloomanddoom.client.BloomAndDoomClient;
import multiteam.bloomanddoom.forge.data.ModDataGen;
import multiteam.bloomanddoom.world.gen.biome.ModTerrablender;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(References.MOD_ID)
public class BloomAndDoomForge {
    public BloomAndDoomForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(References.MOD_ID, modEventBus);

        BloomAndDoom modMain = new BloomAndDoom();
        modMain.init();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            BloomAndDoomClient modClient = new BloomAndDoomClient();
            modClient.init();
        });

        ModTerrablender modTerraBlender = new ModTerrablender();
        modTerraBlender.init();

        modEventBus.addListener(ModDataGen::onModDataGen);
    }
}
