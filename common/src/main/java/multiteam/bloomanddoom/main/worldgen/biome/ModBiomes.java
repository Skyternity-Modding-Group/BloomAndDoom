package multiteam.bloomanddoom.main.worldgen.biome;

import multiteam.bloomanddoom.References;
import multiteam.bloomanddoom.main.worldgen.ModPlacements;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.CavePlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> LARGE_FLOWER_BIOME = ResourceKey.create(Registries.BIOME, References.res("large_flower"));

    public static void bootstrap(BootstapContext<Biome> context) {
        context.register(LARGE_FLOWER_BIOME, largeFlowerBiome(context));
    }

    private static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    private static Biome largeFlowerBiome(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnSettings = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnSettings);
        BiomeDefaultFeatures.commonSpawns(spawnSettings);

        var generationSettings = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        BiomeGenerationSettings.Builder builder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(builder);
        BiomeDefaultFeatures.addDefaultFlowers(generationSettings);
        BiomeDefaultFeatures.addDefaultOres(generationSettings);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationSettings);
        BiomeDefaultFeatures.addDefaultGrass(generationSettings);

        generationSettings.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        BiomeDefaultFeatures.addDefaultMushrooms(generationSettings);
        BiomeDefaultFeatures.addDefaultExtraVegetation(generationSettings);

        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_DANDELION_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_POPPY_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_BLUE_ORCHID_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_ALLIUM_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_RED_TULIP_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_ORANGE_TULIP_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_WHITE_TULIP_PLACED);
        generationSettings.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacements.LARGE_PINK_TULIP_PLACED);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.4f)
                .temperature(0.8f)
                .mobSpawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .fogColor(0xc0d8ff)
                        .skyColor(0x78a7ff)
                        .waterColor(0x3f76e4)
                        .waterFogColor(0x050533)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .build())
                .build();
    }

}
