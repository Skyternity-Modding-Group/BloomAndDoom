package multiteam.bloomanddoom.terrablender.fabric;

import multiteam.bloomanddoom.world.gen.biome.ModTerrablender;
import terrablender.api.TerraBlenderApi;

public class BloomAndDoomTerraBlenderFabric implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        ModTerrablender modTerraBlender = new ModTerrablender();
        modTerraBlender.init();
    }
}
