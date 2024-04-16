package multiteam.bloomanddoom.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.block.entity.ModBlockEntityTypes;
import multiteam.bloomanddoom.entity.ModEntityTypes;
import multiteam.bloomanddoom.growableflower.GrowableFlower;
import multiteam.bloomanddoom.growableflower.GrowableFlowerRegistry;
import multiteam.bloomanddoom.init.References;
import multiteam.bloomanddoom.item.ModItems;
import multiteam.bloomanddoom.tags.ModBlockTags;
import multiteam.bloomanddoom.world.gen.ModFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private static final RegistrarManager REGISTRAR_MANAGER = RegistrarManager.get(References.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(References.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(References.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(References.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(References.MOD_ID, Registries.BLOCK_ENTITY_TYPE);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(References.MOD_ID, Registries.ENTITY_TYPE);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(References.MOD_ID, Registries.FEATURE);

    public static final Registrar<GrowableFlower> GROWABLE_FLOWER = REGISTRAR_MANAGER.<GrowableFlower>builder(BloomAndDoom.res("growable_flower")).saveToDisc().syncToClients().build();

    @Deprecated
    public static final List<GrowableFlower> GROWABLE_FLOWERS = new ArrayList<>();

    public static void register() {
        CREATIVE_MODE_TABS.register();
        BLOCKS.register();
        ITEMS.register();
        BLOCK_ENTITY_TYPES.register();
        ENTITY_TYPES.register();
        FEATURES.register();

        ModBlocks.init();
        ModItems.init();
        ModBlockEntityTypes.init();
        ModEntityTypes.init();
        ModFeatures.init();

        GrowableFlowerRegistry.init();

        ModBlockTags.init();
    }
}
