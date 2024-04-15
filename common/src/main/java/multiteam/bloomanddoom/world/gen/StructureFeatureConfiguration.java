package multiteam.bloomanddoom.world.gen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record StructureFeatureConfiguration(ResourceLocation structureId,
                                            boolean ignoreAirBlocks, int count, double chance) implements FeatureConfiguration {
    public static final Codec<StructureFeatureConfiguration> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    ResourceLocation.CODEC.fieldOf("structure").forGetter(StructureFeatureConfiguration::structureId),
                    Codec.BOOL.optionalFieldOf("ignore_air_blocks", true).forGetter(StructureFeatureConfiguration::ignoreAirBlocks),
                    Codec.INT.fieldOf("count").forGetter(StructureFeatureConfiguration::count),
                    Codec.DOUBLE.fieldOf("chance").forGetter(StructureFeatureConfiguration::chance)
            ).apply(instance, StructureFeatureConfiguration::new));
}
