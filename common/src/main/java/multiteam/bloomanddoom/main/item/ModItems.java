package multiteam.bloomanddoom.main.item;

import multiteam.bloomanddoom.main.Registration;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModItems {
    public static final CreativeModeTab BLOOM_AND_DOOM_ITEMS = new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 0)
            .displayItems((itemDisplayParameters, output) -> {
                // Add all items here
            })
            .title(Component.literal("Bloom and Doom"))
            .icon(() -> new ItemStack(Items.POPPY))
            .build();

    public static void register() {
        Registration.CREATIVE_MODE_TABS.register("bloom_and_doom", () -> BLOOM_AND_DOOM_ITEMS);
    }
}
