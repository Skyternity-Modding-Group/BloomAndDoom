package multiteam.bloomanddoom.block;

import multiteam.bloomanddoom.block.entity.DamagingBlockEntity;
import multiteam.bloomanddoom.world.Tickable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ThornyStemBlock extends FlowerStemBlock implements EntityBlock {
    public ThornyStemBlock() {
        super(Properties.of().randomTicks());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DamagingBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
         return Tickable.createTicker(blockEntityType);
    }
}
