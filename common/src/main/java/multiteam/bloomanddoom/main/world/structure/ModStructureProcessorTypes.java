package multiteam.bloomanddoom.main.world.structure;

import multiteam.bloomanddoom.main.IgnoreAirBlocksProcessor;
import multiteam.bloomanddoom.main.growable_flower.GrowMethodProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;

public class ModStructureProcessorTypes {
    public static final StructureProcessorType<IgnoreAirBlocksProcessor> IGNORE_AIR_BLOCKS = StructureProcessorType.register("bloomanddoom_ignore_air_blocks", IgnoreAirBlocksProcessor.CODEC);
    public static final StructureProcessorType<GrowMethodProcessor> GROW_METHOD = StructureProcessorType.register("bloomanddoom_grow_method", GrowMethodProcessor.CODEC);
}
