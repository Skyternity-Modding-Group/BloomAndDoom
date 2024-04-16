package multiteam.bloomanddoom.block;

import multiteam.bloomanddoom.block.entity.DamagingBlockEntity;
import multiteam.bloomanddoom.world.Tickable;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;

public class ThornyStemBlock extends FlowerStemBlock implements EntityBlock {
    public ThornyStemBlock() {
        super(Properties.of().mapColor(MapColor.PLANT).sound(SoundType.STEM).instrument(NoteBlockInstrument.BANJO).strength(2.0F, 3.0F).ignitedByLava());
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
