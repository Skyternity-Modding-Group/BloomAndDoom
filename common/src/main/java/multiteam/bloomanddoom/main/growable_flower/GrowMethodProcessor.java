package multiteam.bloomanddoom.main.growable_flower;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import multiteam.bloomanddoom.main.world.structure.ModStructureProcessorTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GrowMethodProcessor extends StructureProcessor {
    public static final Codec<GrowMethodProcessor> CODEC = RecordCodecBuilder.create(instance -> instance.group(GrowableFlower.GrowMethod.CODEC.fieldOf("grow_method").forGetter(GrowMethodProcessor::getGrowMethod)).apply(instance, GrowMethodProcessor::new));

    private final GrowableFlower.GrowMethod method;
    private final List<Function<ServerLevelAccessor, Entity>> entities = new ArrayList<>();

    public GrowMethodProcessor(GrowableFlower.GrowMethod method) {
        this.method = method;
    }

    private GrowableFlower.GrowMethod getGrowMethod() {
        return method;
    }

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(LevelReader level, BlockPos blockPos, BlockPos pos, StructureTemplate.StructureBlockInfo blockInfo, StructureTemplate.StructureBlockInfo relativeBlockInfo, StructurePlaceSettings settings) {
        switch (getGrowMethod()) {
            case DEFAULT -> {
                if (!blockInfo.state().isAir())
                    return super.processBlock(level, blockPos, pos, blockInfo, relativeBlockInfo, settings);
            }
            case DROP_IF_OCCUPIED -> {
                if (!blockInfo.state().isAir() && !level.getBlockState(blockPos).isAir())
                    this.entities.add((levelAccessor) -> new ItemEntity(levelAccessor.getLevel(), pos.getX(), pos.getY(), pos.getZ(), levelAccessor.getBlockState(blockPos).getBlock().asItem().getDefaultInstance()));
            }
        }

        return super.processBlock(level, blockPos, pos, blockInfo, relativeBlockInfo, settings);
    }

    @Override
    public @NotNull List<StructureTemplate.StructureBlockInfo> finalizeProcessing(ServerLevelAccessor serverLevelAccessor, BlockPos blockPos, BlockPos blockPos2, List<StructureTemplate.StructureBlockInfo> list, List<StructureTemplate.StructureBlockInfo> list2, StructurePlaceSettings structurePlaceSettings) {
        for (Function<ServerLevelAccessor, Entity> entity : entities) {
            entity.apply(serverLevelAccessor).setPos(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        }

        return super.finalizeProcessing(serverLevelAccessor, blockPos, blockPos2, list, list2, structurePlaceSettings);
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return ModStructureProcessorTypes.GROW_METHOD;
    }
}
