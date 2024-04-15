package multiteam.bloomanddoom.forge.data;

import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.block.PetalBlock;
import multiteam.bloomanddoom.item.ModItems;
import multiteam.bloomanddoom.init.References;
import multiteam.bloomanddoom.tags.ModItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTagLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTagLookup, References.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider arg) {
        IntrinsicTagAppender<Item> petalItems = tag(ModItemTags.PETAL_ITEMS);
        IntrinsicTagAppender<Item> stems = tag(ModItemTags.STEMS);
        IntrinsicTagAppender<Item> planks = tag(ItemTags.PLANKS);
        IntrinsicTagAppender<Item> logs = tag(ItemTags.LOGS);
        IntrinsicTagAppender<Item> fences = tag(ItemTags.WOODEN_FENCES);
        IntrinsicTagAppender<Item> fenceGates = tag(ItemTags.FENCE_GATES);
        IntrinsicTagAppender<Item> doors = tag(ItemTags.WOODEN_DOORS);
        IntrinsicTagAppender<Item> trapdoors = tag(ItemTags.WOODEN_TRAPDOORS);
        IntrinsicTagAppender<Item> buttons = tag(ItemTags.WOODEN_BUTTONS);
        IntrinsicTagAppender<Item> pressurePlates = tag(ItemTags.WOODEN_PRESSURE_PLATES);
        IntrinsicTagAppender<Item> slabs = tag(ItemTags.WOODEN_SLABS);
        IntrinsicTagAppender<Item> stairs = tag(ItemTags.WOODEN_STAIRS);
        IntrinsicTagAppender<Item> signs = tag(ItemTags.SIGNS);
        IntrinsicTagAppender<Item> hangingSigns = tag(ItemTags.HANGING_SIGNS);

        for (PetalBlock petalItem : ModBlocks.getPetalBlocks().toList()) {
            petalItems.add(petalItem.asItem());
        }

        logs.addTag(ModItemTags.STEMS);

        planks.add(ModBlocks.STEM_PLANKS.get().asItem());
        stems.add(ModBlocks.STEM.get().asItem());
        fences.add(ModBlocks.STEM_FENCE.get().asItem());
        fenceGates.add(ModBlocks.STEM_FENCE_GATE.get().asItem());
        doors.add(ModBlocks.STEM_DOOR.get().asItem());
        trapdoors.add(ModBlocks.STEM_TRAPDOOR.get().asItem());
        buttons.add(ModBlocks.STEM_BUTTON.get().asItem());
        pressurePlates.add(ModBlocks.STEM_PRESSURE_PLATE.get().asItem());
        slabs.add(ModBlocks.STEM_SLAB.get().asItem());
        stairs.add(ModBlocks.STEM_STAIRS.get().asItem());
        signs.add(ModItems.STEM_SIGN.get());
        hangingSigns.add(ModItems.STEM_HANGING_SIGN.get());
    }
}
