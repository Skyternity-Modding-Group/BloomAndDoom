package multiteam.bloomanddoom.world.gen;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.registry.Registration;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModFeatures {
    public static final RegistrySupplier<Feature<StructureFeatureConfiguration>> STRUCTURE_FEATURE = Registration.FEATURES.register("structure_feature", StructureFeature::new);

    public static void init() {

    }
}
