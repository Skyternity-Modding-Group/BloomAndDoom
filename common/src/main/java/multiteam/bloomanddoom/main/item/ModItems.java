package multiteam.bloomanddoom.main.item;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.main.Registration;
import multiteam.bloomanddoom.main.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class ModItems {
    public static final List<RegistrySupplier<BlockItem>> BLOCK_ITEMS = ModBlocks.getAllBlocks().map(ModItems::registerBlockItem).toList();

    public static Stream<BlockItem> getBlockItems() {
        return BLOCK_ITEMS.stream().map(RegistrySupplier::getOrNull).filter(Objects::nonNull);
    }

    private static RegistrySupplier<BlockItem> registerBlockItem(RegistrySupplier<Block> block) {
        return Registration.ITEMS.register(block.getId(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register() {
        Registration.CREATIVE_MODE_TABS.register("bloom_and_doom", () -> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0)
                .displayItems((itemDisplayParameters, output) -> {
                    // Add all items here
                    for (RegistrySupplier<Item> item : Registration.ITEMS) {
                        output.accept(new ItemStack(item.get()));
                    }
                })
                .title(Component.literal("Bloom and Doom"))
                .icon(() -> new ItemStack(Items.POPPY))
                .build());
    }
}
