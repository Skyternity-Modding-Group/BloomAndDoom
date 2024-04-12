package multiteam.bloomanddoom.main.worldgen;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.main.Registration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModFeatures {
    public static final RegistrySupplier<Feature<StructureFeatureConfiguration>> STRUCTURE_FEATURE = Registration.FEATURES.register("structure_feature", StructureFeature::new);

    public static void register() {

    }
}
