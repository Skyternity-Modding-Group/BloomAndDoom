package multiteam.bloomanddoom.main.growable_flower;

import multiteam.bloomanddoom.main.IgnoreAirBlocksProcessor;
import multiteam.bloomanddoom.main.util.StructureTemplateFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;

public class StructureGrowableFlower extends GrowableFlower {
    private final StructureTemplateFactory structureFactory;

    public StructureGrowableFlower(Block flower, StructureTemplateFactory structureFactory) {
        super(flower);
        this.structureFactory = structureFactory;
    }

    @Override
    public void growAt(BlockPos basePos, ServerLevelAccessor levelAccessor, RandomSource random, @NotNull GrowMethod method) {
        StructureTemplate template = this.structureFactory.create(levelAccessor.getServer());
        BlockPos pos = basePos.offset(-template.getSize().getX() / 2, 0, -template.getSize().getZ() / 2);
        StructurePlaceSettings settings = new StructurePlaceSettings().setRandom(random)
                .addProcessor(new IgnoreAirBlocksProcessor())
                .addProcessor(new GrowMethodProcessor(method))
                .setRotationPivot(new BlockPos(template.getSize().getX() / 2, 0, template.getSize().getZ() / 2))
                .setRotation(Rotation.getRandom(random));

        template.placeInWorld(levelAccessor, pos, pos, settings.addProcessor(new IgnoreAirBlocksProcessor()), random, 2);
    }
}


