package multiteam.bloomanddoom.forge.data;

import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.References;
import multiteam.bloomanddoom.forge.data.client.ModBlockModelProvider;
import multiteam.bloomanddoom.forge.data.worldgen.ModWorldGenProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModDataGen {
    @SubscribeEvent
    public static void onModDataGen(GatherDataEvent event) {
        event.getGenerator().addProvider(event.includeServer(), new ModWorldGenProvider(event.getGenerator().getPackOutput(), event.getLookupProvider()));

        event.getGenerator().addProvider(event.includeClient(), new ModBlockModelProvider(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));
    }
}
