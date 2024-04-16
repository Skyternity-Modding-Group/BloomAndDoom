package multiteam.bloomanddoom.item;

import dev.architectury.registry.fuel.FuelRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.registry.Registration;
import multiteam.bloomanddoom.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

public class ModItems {
    private static final List<RegistrySupplier<Item>> BLOCK_ITEMS = ModBlocks.getAllBlocks().filter(ModItems::isValidBlock).map(ModItems::registerBlockItem).toList();

    public static final RegistrySupplier<SignItem> STEM_SIGN = registerSign(ModBlocks.STEM_SIGN, ModBlocks.STEM_WALL_SIGN);
    public static final RegistrySupplier<HangingSignItem> STEM_HANGING_SIGN = registerHangingSign(ModBlocks.STEM_HANGING_SIGN, ModBlocks.STEM_WALL_HANGING_SIGN);
    public static final RegistrySupplier<BoatItem> STEM_BOAT = Registration.ITEMS.register("stem_boat", () -> new ModBoatItem(false, ModBoatType.STEM, new Item.Properties()));
    public static final RegistrySupplier<BoatItem> STEM_CHEST_BOAT = Registration.ITEMS.register("stem_chest_boat", () -> new ModBoatItem(true, ModBoatType.STEM, new Item.Properties()));

    @SuppressWarnings("RedundantIfStatement")
    private static boolean isValidBlock(RegistrySupplier<? extends Block> sup) {
        if (sup == ModBlocks.STEM_WALL_HANGING_SIGN) return false;
        if (sup == ModBlocks.STEM_WALL_SIGN) return false;
        if (sup == ModBlocks.STEM_HANGING_SIGN) return false;
        if (sup == ModBlocks.STEM_SIGN) return false;

        return true;
    }

    private static RegistrySupplier<SignItem> registerSign(RegistrySupplier<StandingSignBlock> sign, RegistrySupplier<WallSignBlock> wallSign) {
        return Registration.ITEMS.register(sign.getId(), () -> new SignItem(new Item.Properties(), sign.get(), wallSign.get()));
    }

    private static RegistrySupplier<HangingSignItem> registerHangingSign(RegistrySupplier<CeilingHangingSignBlock> sign, RegistrySupplier<WallHangingSignBlock> wallSign) {
        return Registration.ITEMS.register(sign.getId(), () -> new HangingSignItem(sign.get(), wallSign.get(), new Item.Properties()));
    }

    public static Stream<BlockItem> getBlockItems() {
        return BLOCK_ITEMS.stream().map(RegistrySupplier::getOrNull).filter(item -> item instanceof BlockItem).map(BlockItem.class::cast);
    }

    private static RegistrySupplier<Item> registerBlockItem(RegistrySupplier<Block> block) {
        return Registration.ITEMS.register(block.getId(), () -> createBlockItem(block));
    }

    private static @NotNull Item createBlockItem(RegistrySupplier<Block> block) {
        Block blk = block.get();

        return new BlockItem(blk, new Item.Properties());
    }

    public static void init() {
        Registration.CREATIVE_MODE_TABS.register("bloom_and_doom", () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0)
                .displayItems((itemDisplayParameters, output) -> {
                    // Add all items here
                    for (RegistrySupplier<Item> itemSup : Registration.ITEMS) {
                        Item item = itemSup.get();
                        output.accept(new ItemStack(item));
                    }
                })
                .title(Component.literal("Bloom and Doom"))
                .icon(() -> new ItemStack(Items.POPPY))
                .build());
    }

    public static void registerFuels() {
        FuelRegistry.register(200, ModBlocks.getPetalBlocks().map(Block::asItem).toArray(Item[]::new));
    }
}
