package multiteam.bloomanddoom.growableflower;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;
import oshi.util.tuples.Pair;

public class BlockListGrowableFlower extends GrowableFlower {
    private final Iterable<? extends Pair<BlockState, Vector3d>> blockStructure;

    public BlockListGrowableFlower(Block flower, Iterable<? extends Pair<BlockState, Vector3d>> blockStructure) {
        super(flower);
        this.blockStructure = blockStructure;
    }

    @Override
    public void growAt(BlockPos basePos, ServerLevelAccessor levelAccessor, RandomSource random, @NotNull GrowMethod method) {
        for (Pair<BlockState, Vector3d> pair : this.blockStructure) {
            BlockPos currentPos = new BlockPos((int) (basePos.getX() + pair.getB().x), (int) (basePos.getY() + pair.getB().y), (int) (basePos.getZ() + pair.getB().z));
            switch (method) {
                case DEFAULT -> levelAccessor.setBlock(currentPos, pair.getA(), Block.UPDATE_ALL);
                case DROP_IF_OCCUPIED -> {
                    if (levelAccessor.getBlockState(currentPos).is(pair.getA().getBlock())) {
                        levelAccessor.destroyBlock(currentPos, true);
                    }

                    if (levelAccessor.getBlockState(currentPos).isAir() || levelAccessor.getBlockState(currentPos).is(this.getFlower())) {
                        levelAccessor.setBlock(currentPos, pair.getA(), Block.UPDATE_ALL);
                    } else if (levelAccessor instanceof ServerLevel level) {
                        levelAccessor.addFreshEntity(new ItemEntity(level, basePos.getX(), basePos.getY(), basePos.getZ(), new ItemStack(pair.getA().getBlock().asItem())));
                    }
                }
            }
        }
    }
}
