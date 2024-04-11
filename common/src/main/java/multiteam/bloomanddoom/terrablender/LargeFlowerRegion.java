package multiteam.bloomanddoom.terrablender;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import terrablender.api.ModifiedVanillaOverworldBuilder;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.TerrablenderOverworldBiomeBuilder;

public class LargeFlowerRegion extends Region {
    public LargeFlowerRegion(ResourceLocation name, RegionType type, int weight) {
        super(name, type, weight);

        var builder = new ModifiedVanillaOverworldBuilder();
        builder.replaceBiome(Biomes.PLAINS, ModBiomes.LARGE_FLOWER);
    }
}
