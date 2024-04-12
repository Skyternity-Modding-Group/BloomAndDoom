package multiteam.bloomanddoom.main;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.References;
import multiteam.bloomanddoom.main.block.ModBlocks;
import multiteam.bloomanddoom.main.growable_flower.GrowableFlower;
import multiteam.bloomanddoom.main.growable_flower.GrowableFlowerRegistry;
import multiteam.bloomanddoom.main.item.ModItems;
import multiteam.bloomanddoom.main.worldgen.ModFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;

import java.util.ArrayList;
import java.util.List;

public class Registration {
    private static final RegistrarManager REGISTRAR_MANAGER = RegistrarManager.get(References.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(References.MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(References.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(References.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(References.MOD_ID, Registries.FEATURE);

    public static final Registrar<GrowableFlower> GROWABLE_FLOWER = REGISTRAR_MANAGER.<GrowableFlower>builder(BloomAndDoom.res("growable_flower")).saveToDisc().syncToClients().build();

    @Deprecated
    public static final List<GrowableFlower> GROWABLE_FLOWERS = new ArrayList<>();

    public static void register() {
        BLOCKS.register();
        ITEMS.register();
        FEATURES.register();
        CREATIVE_MODE_TABS.register();

        ModBlocks.register();
        ModItems.register();
        ModFeatures.register();

        GrowableFlowerRegistry.register();
    }
}
