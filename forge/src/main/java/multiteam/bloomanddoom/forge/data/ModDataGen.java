package multiteam.bloomanddoom.forge.data;

import multiteam.bloomanddoom.forge.data.client.ModBlockModelProvider;
import multiteam.bloomanddoom.forge.data.worldgen.ModWorldGenProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModDataGen {
    @SubscribeEvent
    public static void onModDataGen(GatherDataEvent event) {
        event.getGenerator().addProvider(event.includeServer(), new ModWorldGenProvider(event.getGenerator().getPackOutput(), event.getLookupProvider()));
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), event.getExistingFileHelper());
        event.getGenerator().addProvider(event.includeServer(), blockTags);
        event.getGenerator().addProvider(event.includeServer(), new ModItemTagsProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), blockTags.contentsGetter(), event.getExistingFileHelper()));
        event.getGenerator().addProvider(event.includeServer(), new ModRecipeProvider(event.getGenerator().getPackOutput()));
        event.getGenerator().addProvider(event.includeServer(), new ModLootTableProvider(event.getGenerator().getPackOutput()));

        event.getGenerator().addProvider(event.includeClient(), new ModBlockModelProvider(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));
    }
}
