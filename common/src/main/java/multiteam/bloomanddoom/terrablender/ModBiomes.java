package multiteam.bloomanddoom.terrablender;

import multiteam.bloomanddoom.References;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.Bootstrap;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> LARGE_FLOWER = ResourceKey.create(Registries.BIOME, References.res("large_flower"));

    public static void init() {

    }
}
