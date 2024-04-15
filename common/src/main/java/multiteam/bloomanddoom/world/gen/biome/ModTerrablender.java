package multiteam.bloomanddoom.world.gen.biome;

import multiteam.bloomanddoom.init.References;
import terrablender.api.Regions;

public class ModTerrablender {
    public void init() {
        Regions.register(new ModOverworldRegion(References.res("overworld"), 5));
    }
}
