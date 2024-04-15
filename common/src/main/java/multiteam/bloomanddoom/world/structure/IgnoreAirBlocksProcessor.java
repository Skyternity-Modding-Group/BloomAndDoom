package multiteam.bloomanddoom.world.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IgnoreAirBlocksProcessor extends StructureProcessor {
    public static final Codec<IgnoreAirBlocksProcessor> CODEC = Codec.unit(IgnoreAirBlocksProcessor::new);

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader level, BlockPos blockPos, BlockPos pos, StructureTemplate.StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo, StructurePlaceSettings settings) {
        if (blockInfo.state().isAir())
            return null;

        return super.processBlock(level, blockPos, pos, blockInfo, relativeBlockInfo, settings);
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return ModStructureProcessorTypes.IGNORE_AIR_BLOCKS;
    }
}
