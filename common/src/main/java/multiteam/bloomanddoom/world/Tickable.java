package multiteam.bloomanddoom.world;

import multiteam.bloomanddoom.block.entity.DamagingBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class Tickable {
    public static <T extends BlockEntity> BlockEntityTicker<T> createTicker(BlockEntityType<T> blockEntityType) {
        return (level, blockPos, blockState, blockEntity) -> {
            if (blockEntity.getType() != blockEntityType) return;

            if (blockEntity instanceof DamagingBlockEntity damagingBE)
                damagingBE.tick();
        };
    }
}
