package multiteam.bloomanddoom.block.entity;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.registry.Registration;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;

@SuppressWarnings("DataFlowIssue")
public class ModBlockEntityTypes {
    public static final RegistrySupplier<BlockEntityType<SignBlockEntity>> CUSTOM_SIGN = Registration.BLOCK_ENTITY_TYPES.register("custom_sign", () -> BlockEntityType.Builder.<SignBlockEntity>of(CustomSignBlockEntity::new, ModBlocks.STEM_SIGN.get(), ModBlocks.STEM_WALL_SIGN.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<SignBlockEntity>> CUSTOM_HANGING_SIGN = Registration.BLOCK_ENTITY_TYPES.register("custom_hanging_sign", () -> BlockEntityType.Builder.<SignBlockEntity>of(CustomHangingSignBlockEntity::new, ModBlocks.STEM_HANGING_SIGN.get(), ModBlocks.STEM_WALL_HANGING_SIGN.get()).build(null));
    public static final RegistrySupplier<BlockEntityType<DamagingBlockEntity>> DAMAGING_BLOCK = Registration.BLOCK_ENTITY_TYPES.register("damaging_block", () -> BlockEntityType.Builder.<DamagingBlockEntity>of(DamagingBlockEntity::new, ModBlocks.THORNY_STEM.get()).build(null));

    public static void init() {

    }
}
