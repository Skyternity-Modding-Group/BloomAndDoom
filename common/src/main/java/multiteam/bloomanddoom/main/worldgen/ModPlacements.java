package multiteam.bloomanddoom.main.worldgen;

import multiteam.bloomanddoom.BloomAndDoom;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ModPlacements {
    private static final Map<ResourceKey<PlacedFeature>, Function<BootstapContext<PlacedFeature>, PlacedFeature>> PLACED_FEATURES = new HashMap<>();

    public static final ResourceKey<PlacedFeature> LARGE_DANDELION_PLACED = register("large_dandelion_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_DANDELION_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    public static final ResourceKey<PlacedFeature> LARGE_POPPY_PLACED = register("large_poppy_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_POPPY_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    public static final ResourceKey<PlacedFeature> LARGE_BLUE_ORCHID_PLACED = register("large_blue_orchid_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_BLUE_ORCHID_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    public static final ResourceKey<PlacedFeature> LARGE_ALLIUM_PLACED = register("large_allium_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_ALLIUM_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

//    public static final ResourceKey<PlacedFeature> LARGE_CORNFLOWER_PLACED = register("large_cornflower_placed", (context) -> new PlacedFeature(
//            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_CORNFLOWER_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
//    ));
//
//    public static final ResourceKey<PlacedFeature> LARGE_LILY_OF_THE_VALLEY_PLACED = register("large_lily_of_the_valley_placed", (context) -> new PlacedFeature(
//            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_LILY_OF_THE_VALLEY_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
//    ));
//
//    public static final ResourceKey<PlacedFeature> LARGE_OXEYE_DAISY_PLACED = register("large_oxeye_daisy_placed", (context) -> new PlacedFeature(
//            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_OXEYE_DAISY_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
//    ));

    public static final ResourceKey<PlacedFeature> LARGE_RED_TULIP_PLACED = register("large_red_tulip_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_RED_TULIP_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    public static final ResourceKey<PlacedFeature> LARGE_ORANGE_TULIP_PLACED = register("large_orange_tulip_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_ORANGE_TULIP_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    public static final ResourceKey<PlacedFeature> LARGE_WHITE_TULIP_PLACED = register("large_white_tulip_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_WHITE_TULIP_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    public static final ResourceKey<PlacedFeature> LARGE_PINK_TULIP_PLACED = register("large_pink_tulip_placed", (context) -> new PlacedFeature(
            context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.LARGE_PINK_TULIP_PLACED), List.of(CountPlacement.of(UniformInt.of(1, 2)))
    ));

    private static ResourceKey<PlacedFeature> register(String name, Function<BootstapContext<PlacedFeature>, PlacedFeature> placedFeature) {
        ResourceLocation res = BloomAndDoom.res(name);
        ResourceKey<PlacedFeature> key = ResourceKey.create(Registries.PLACED_FEATURE, res);
        PLACED_FEATURES.put(key, placedFeature);
        return key;
    }

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        for (var e : PLACED_FEATURES.entrySet()) {
            context.register(e.getKey(), e.getValue().apply(context));
        }
    }
}
