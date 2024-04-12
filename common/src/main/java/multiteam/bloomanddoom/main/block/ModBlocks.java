package multiteam.bloomanddoom.main.block;

import com.google.common.collect.Streams;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.main.Registration;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ModBlocks {
    private static final List<RegistrySupplier<PetalBlock>> PETAL_BLOCKS = Arrays.stream(DyeColor.values()).map(ModBlocks::registerPetalBlock).toList();
    public static final RegistrySupplier<FlowerStemBlock> FLOWER_STEM = Registration.BLOCKS.register("stem", FlowerStemBlock::new);
    public static final RegistrySupplier<FlowerStemBlock> STRIPPED_FLOWER_STEM = Registration.BLOCKS.register("stripped_stem", FlowerStemBlock::new);
    public static final RegistrySupplier<Block> FLOWER_PLANKS = Registration.BLOCKS.register("stem_planks", () -> new Block(BlockBehaviour.Properties.copy(STRIPPED_FLOWER_STEM.get())));
    public static final RegistrySupplier<SlabBlock> FLOWER_PLANKS_SLAB = Registration.BLOCKS.register("stem_planks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(STRIPPED_FLOWER_STEM.get())));
    public static final RegistrySupplier<StairBlock> FLOWER_PLANKS_STAIRS = Registration.BLOCKS.register("stem_planks_stairs", () -> new StairBlock(FLOWER_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(STRIPPED_FLOWER_STEM.get())));

    public static Stream<PetalBlock> getPetalBlocks() {
        return PETAL_BLOCKS.stream().map(RegistrySupplier::getOrNull).filter(Objects::nonNull);
    }

    private static RegistrySupplier<PetalBlock> registerPetalBlock(DyeColor dyeColor) {
        return Registration.BLOCKS.register(dyeColor.getName() + "_petal_block", () -> new PetalBlock(dyeColor));
    }

    public static void register() {
        
    }

    @SuppressWarnings("UnstableApiUsage")
    public static Stream<RegistrySupplier<Block>> getAllBlocks() {
        return Streams.stream(Registration.BLOCKS.iterator());
    }
}
