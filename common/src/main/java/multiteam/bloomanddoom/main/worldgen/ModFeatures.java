package multiteam.bloomanddoom.main.worldgen;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.References;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;

public class ModFeatures {
    private static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(References.MOD_ID, Registries.FEATURE);

    public static final RegistrySupplier<Feature<StructureFeatureConfiguration>> STRUCTURE_FEATURE = REGISTER.register("structure_feature", StructureFeature::new);

    public static void register() {
        REGISTER.register();
    }
}
