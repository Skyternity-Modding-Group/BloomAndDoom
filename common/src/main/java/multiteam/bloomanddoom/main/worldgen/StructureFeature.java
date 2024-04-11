package multiteam.bloomanddoom.main.worldgen;

import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.main.IgnoreAirBlocksProcessor;
import multiteam.bloomanddoom.main.worldgen.biome.ModBiomes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Optional;

public class StructureFeature extends Feature<StructureFeatureConfiguration> {
    public StructureFeature() {
        super(StructureFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
        ServerLevel level = context.level().getLevel();

        if (context.random().nextDouble() < 1 / 5.0) {
            level.getServer().submit(() -> tryPlace(context, level));
            return true;
        }

        return false;

    }

    private static void tryPlace(FeaturePlaceContext<StructureFeatureConfiguration> context, ServerLevel level) {
        StructureTemplate structureTemplate = level.getStructureManager().getOrCreate(context.config().structureId());

        BlockPos origin = context.origin();
        RandomSource random = context.random();
        int originX = origin.getX() + random.nextInt(16);
        int originZ = origin.getZ() + random.nextInt(16);
        int originY = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, originX, originZ);
        origin = new BlockPos(originX, originY, originZ);

        if (origin.getY() <= 64 || origin.getY() + structureTemplate.getSize().getY() >= level.getHeight()) return;

        if (!level.getBiome(origin).is(ModBiomes.LARGE_FLOWER_BIOME)) return;

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRandom(random)
                .setRotationPivot(origin);

        if (context.config().ignoreAirBlocks())
            settings = settings.addProcessor(new IgnoreAirBlocksProcessor());

        structureTemplate.placeInWorld(level, origin, origin, settings, random, 2);
    }
}
