package multiteam.bloomanddoom.world.gen;

import multiteam.bloomanddoom.world.gen.biome.ModBiomes;
import multiteam.bloomanddoom.world.structure.IgnoreAirBlocksProcessor;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

public class StructureFeature extends Feature<StructureFeatureConfiguration> {
    public StructureFeature() {
        super(StructureFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
        ServerLevel level = context.level().getLevel();

        level.getServer().submit(() -> tryPlace(context, level));
        return true;

    }

    private static void tryPlace(FeaturePlaceContext<StructureFeatureConfiguration> context, ServerLevel level) {
        StructureTemplate template = level.getStructureManager().getOrCreate(context.config().structureId());

        BlockPos origin = context.origin();
        RandomSource random = context.random();
        int originX = origin.getX() + (random.nextInt(16) - 8) * 10;
        int originZ = origin.getZ() + (random.nextInt(16) - 8) * 10;
        int originY = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, originX, originZ);
        origin = new BlockPos(originX, originY, originZ);

        if (origin.getY() <= 64 || origin.getY() + template.getSize().getY() >= level.getHeight()) return;
        if (!level.getBiome(origin).is(ModBiomes.LARGE_FLOWER_BIOME)) return;

        BlockPos pos = origin.offset(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);
        if (!checkBlocks(level, pos, template)) return;

        StructurePlaceSettings settings = new StructurePlaceSettings()
                .setRotationPivot(new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2))
                .setRotation(Rotation.getRandom(random));

        if (context.config().ignoreAirBlocks())
            settings = settings.addProcessor(new IgnoreAirBlocksProcessor());

        template.placeInWorld(level, pos, pos, settings.addProcessor(new IgnoreAirBlocksProcessor()), random, 2);
    }

    public static boolean checkBlocks(LevelAccessor level, BlockPos pos, StructureTemplate template) {
        for (int x = pos.getX() - template.getSize().getX() / 2; x < pos.getX() + template.getSize().getX() / 2; x++) {
            for (int z = pos.getZ() - template.getSize().getZ() / 2; z < pos.getZ() + template.getSize().getZ() / 2; z++) {
                for (int y = pos.getY(); y < pos.getY() + template.getSize().getY(); y++) {
                    if (!level.getBlockState(new BlockPos(x, y, z)).isAir()) return false;
                }
            }
        }

        return true;
    }
}
