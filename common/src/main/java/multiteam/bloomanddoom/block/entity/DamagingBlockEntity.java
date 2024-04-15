package multiteam.bloomanddoom.block.entity;

import multiteam.bloomanddoom.block.ThornyStemBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;

public class DamagingBlockEntity extends BlockEntity {
    public DamagingBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockState) {
        super(type, pos, blockState);
    }

    public DamagingBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.DAMAGING_BLOCK.get(), blockPos, blockState);
    }

    public void tick() {
        if (level == null) return;

        BlockPos pos = this.getBlockPos();
        AABB aabb = new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1, pos.getZ() + 1);
        aabb = aabb.inflate(1 / 16.0);

        aabb = switch (this.getBlockState().getValue(ThornyStemBlock.AXIS)) {
            case X -> aabb.inflate(-2 / 16.0, 0, 0);
            case Y -> aabb.inflate(0, -2 / 16.0, 0);
            case Z -> aabb.inflate(0, 0, -2 / 16.0);
        };

        for (LivingEntity e : level.getEntities(EntityTypeTest.forClass(LivingEntity.class), aabb, LivingEntity::isAlive)) {
            if (e.hurt(level.damageSources().cactus(), 0.5f)) {
                System.out.println("aabb = " + aabb);
                if (e.getRandom().nextInt(10) == 0) e.addEffect(new MobEffectInstance(MobEffects.POISON, 120, 0));
            }
        }
    }
}
