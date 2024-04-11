package multiteam.bloomanddoom.forge;

import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.client.BloomAndDoomClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;

@Mod(BloomAndDoom.MOD_ID)
public class BloomAndDoomForge {
    public BloomAndDoomForge() {
        BloomAndDoom modMain = new BloomAndDoom();
        modMain.init();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            BloomAndDoomClient modClient = new BloomAndDoomClient();
            modClient.init();
        });
    }
}
