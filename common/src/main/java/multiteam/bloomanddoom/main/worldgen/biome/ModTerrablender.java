package multiteam.bloomanddoom.main.worldgen.biome;

import multiteam.bloomanddoom.References;
import terrablender.api.Regions;

public class ModTerrablender {
    public void init() {
        Regions.register(new ModOverworldRegion(References.res("overworld"), 5));
    }
}
