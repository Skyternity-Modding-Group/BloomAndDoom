package multiteam.bloomanddoom.block;

import com.google.common.collect.Streams;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.BlockEvent;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.hooks.item.tool.AxeItemHooks;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.block.entity.CustomHangingSignBlockEntity;
import multiteam.bloomanddoom.block.entity.CustomSignBlockEntity;
import multiteam.bloomanddoom.block.wood.ModWoodType;
import multiteam.bloomanddoom.event.StemEvents;
import multiteam.bloomanddoom.registry.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static net.minecraft.world.level.block.Blocks.*;

public class ModBlocks {
    private static final List<RegistrySupplier<PetalBlock>> PETAL_BLOCKS = Arrays.stream(DyeColor.values()).map(ModBlocks::registerPetalBlock).toList();
    public static final RegistrySupplier<FlowerStemBlock> STEM = Registration.BLOCKS.register("stem", FlowerStemBlock::new);
    public static final RegistrySupplier<ThornyStemBlock> THORNY_STEM = Registration.BLOCKS.register("thorny_stem", ThornyStemBlock::new);
    public static final RegistrySupplier<FlowerStemBlock> STRIPPED_STEM = Registration.BLOCKS.register("stripped_stem", FlowerStemBlock::new);
    public static final RegistrySupplier<Block> STEM_PLANKS = Registration.BLOCKS.register("stem_planks", () -> new Block(BlockBehaviour.Properties.copy(CRIMSON_PLANKS)));
    public static final RegistrySupplier<Block> STEM_BUNDLE = Registration.BLOCKS.register("stem_bundle", () -> new Block(BlockBehaviour.Properties.copy(CRIMSON_HYPHAE)));
    public static final RegistrySupplier<Block> STRIPPED_STEM_BUNDLE = Registration.BLOCKS.register("stripped_stem_bundle", () -> new Block(BlockBehaviour.Properties.copy(STRIPPED_CRIMSON_HYPHAE)));
    public static final RegistrySupplier<SlabBlock> STEM_SLAB = Registration.BLOCKS.register("stem_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(CRIMSON_SLAB)));
    public static final RegistrySupplier<StairBlock> STEM_STAIRS = Registration.BLOCKS.register("stem_stairs", () -> new StairBlock(STEM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(CRIMSON_STAIRS)));
    public static final RegistrySupplier<DoorBlock> STEM_DOOR = Registration.BLOCKS.register("stem_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(CRIMSON_DOOR), ModBlockSetType.STEM));
    public static final RegistrySupplier<TrapDoorBlock> STEM_TRAPDOOR = Registration.BLOCKS.register("stem_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(CRIMSON_TRAPDOOR), ModBlockSetType.STEM));
    public static final RegistrySupplier<StandingSignBlock> STEM_SIGN = Registration.BLOCKS.register("stem_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.copy(CRIMSON_SIGN), ModWoodType.STEM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new CustomSignBlockEntity(pos, state);
        }
    });
    public static final RegistrySupplier<WallSignBlock> STEM_WALL_SIGN = Registration.BLOCKS.register("stem_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.copy(CRIMSON_WALL_SIGN), ModWoodType.STEM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new CustomSignBlockEntity(pos, state);
        }
    });
    public static final RegistrySupplier<CeilingHangingSignBlock> STEM_HANGING_SIGN = Registration.BLOCKS.register("stem_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.copy(CRIMSON_HANGING_SIGN), ModWoodType.STEM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new CustomHangingSignBlockEntity(pos, state);
        }
    });
    public static final RegistrySupplier<WallHangingSignBlock> STEM_WALL_HANGING_SIGN = Registration.BLOCKS.register("stem_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.copy(CRIMSON_WALL_HANGING_SIGN), ModWoodType.STEM) {
        @Override
        public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
            return new CustomHangingSignBlockEntity(pos, state);
        }
    });
    public static final RegistrySupplier<FenceBlock> STEM_FENCE = Registration.BLOCKS.register("stem_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(CRIMSON_FENCE)));
    public static final RegistrySupplier<FenceGateBlock> STEM_FENCE_GATE = Registration.BLOCKS.register("stem_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(CRIMSON_FENCE_GATE), ModWoodType.STEM));
    public static final RegistrySupplier<ButtonBlock> STEM_BUTTON = Registration.BLOCKS.register("stem_button", () -> new ButtonBlock(BlockBehaviour.Properties.copy(CRIMSON_BUTTON), ModBlockSetType.STEM, 30, true));
    public static final RegistrySupplier<PressurePlateBlock> STEM_PRESSURE_PLATE = Registration.BLOCKS.register("stem_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(CRIMSON_PRESSURE_PLATE), ModBlockSetType.STEM));

    public static Stream<PetalBlock> getPetalBlocks() {
        return PETAL_BLOCKS.stream().map(RegistrySupplier::getOrNull).filter(Objects::nonNull);
    }

    private static RegistrySupplier<PetalBlock> registerPetalBlock(DyeColor dyeColor) {
        return Registration.BLOCKS.register(dyeColor.getName() + "_petal_block", () -> new PetalBlock(dyeColor));
    }

    public static void init() {

    }

    @SuppressWarnings("UnstableApiUsage")
    public static Stream<RegistrySupplier<Block>> getAllBlocks() {
        return Streams.stream(Registration.BLOCKS.iterator());
    }

    public static void registerStrippables() {
        AxeItemHooks.addStrippable(ModBlocks.STEM.get(), ModBlocks.STRIPPED_STEM.get());
        AxeItemHooks.addStrippable(ModBlocks.THORNY_STEM.get(), ModBlocks.STRIPPED_STEM.get());

        InteractionEvent.RIGHT_CLICK_BLOCK.register((player, hand, blockPos, face) -> {
            var world = player.level();

            if (world.isClientSide) {
                return EventResult.pass();
            }

            var blockState = world.getBlockState(blockPos);
            var usedItem = player.getItemInHand(hand);

            if (blockState.getBlock() instanceof StemBlock && usedItem.getItem() instanceof AxeItem) {
                StemEvents.STEM_STRIPPED.invoker().onStemStripped(blockPos, blockState, usedItem);
            }

            return EventResult.pass();
        });
    }
}
