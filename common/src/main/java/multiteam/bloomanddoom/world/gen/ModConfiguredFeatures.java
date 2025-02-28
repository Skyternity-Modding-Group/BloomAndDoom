package multiteam.bloomanddoom.world.gen;

import multiteam.bloomanddoom.BloomAndDoom;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ModConfiguredFeatures {
    private static final Map<ResourceKey<ConfiguredFeature<?, ?>>, Function<BootstapContext<ConfiguredFeature<?, ?>>, ConfiguredFeature<?, ?>>> PLACED_FEATURES = new HashMap<>();

public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_DANDELION_PLACED = register("large_dandelion_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("dandelion"), true, 1, 0.2)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_POPPY_PLACED = register("large_poppy_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("poppy"), true, 1, 0.2)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_BLUE_ORCHID_PLACED = register("large_blue_orchid_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("blue_orchid"), true, 1, 0.1)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ALLIUM_PLACED = register("large_allium_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("allium"), true, 1, 0.1)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_AZURE_BLUET_PLACED = register("large_azure_bluet_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("azure_bluet"), true, 1, 0.1)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_RED_TULIP_PLACED = register("large_red_tulip_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("red_tulip"), true, 1, 0.08)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_ORANGE_TULIP_PLACED = register("large_orange_tulip_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("orange_tulip"), true, 1, 0.8)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_WHITE_TULIP_PLACED = register("large_white_tulip_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("white_tulip"), true, 1, 0.08)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_PINK_TULIP_PLACED = register("large_pink_tulip_placed", (context) -> new ConfiguredFeature<>(ModFeatures.STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(BloomAndDoom.res("pink_tulip"), true, 1, 0.08)));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_FLOWER_VEGETATION = register("large_flower_vegetation", (context) -> new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_DANDELION_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_POPPY_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_BLUE_ORCHID_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_ALLIUM_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_AZURE_BLUET_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_RED_TULIP_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_ORANGE_TULIP_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_WHITE_TULIP_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_PINK_TULIP_PLACED), 0.005F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(TreePlacements.OAK_CHECKED), 0.5F),
            new WeightedPlacedFeature(context.lookup(Registries.PLACED_FEATURE).getOrThrow(TreePlacements.FANCY_OAK_CHECKED), 0.03F)
    ), context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacements.LARGE_ALLIUM_PLACED))));

    private static ResourceKey<ConfiguredFeature<?, ?>> register(String name, Function<BootstapContext<ConfiguredFeature<?, ?>>, ConfiguredFeature<?, ?>> cfg) {
        ResourceLocation res = BloomAndDoom.res(name);
        ResourceKey<ConfiguredFeature<?, ?>> key = ResourceKey.create(Registries.CONFIGURED_FEATURE, res);
        PLACED_FEATURES.put(key, cfg);
        return key;
    }

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        for (var e : PLACED_FEATURES.entrySet()) {
            context.register(e.getKey(), e.getValue().apply(context));
        }
    }
}
