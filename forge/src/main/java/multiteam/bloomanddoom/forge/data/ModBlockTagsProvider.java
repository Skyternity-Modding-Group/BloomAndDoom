package multiteam.bloomanddoom.forge.data;

import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.block.PetalBlock;
import multiteam.bloomanddoom.init.References;
import multiteam.bloomanddoom.tags.ModBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, References.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider arg) {
        IntrinsicTagAppender<Block> petalBlocks = tag(ModBlockTags.PETAL_BLOCKS);
        IntrinsicTagAppender<Block> stems = tag(ModBlockTags.STEMS);
        IntrinsicTagAppender<Block> mineableWithHoe = tag(BlockTags.MINEABLE_WITH_HOE);
        IntrinsicTagAppender<Block> planks = tag(BlockTags.PLANKS);
        IntrinsicTagAppender<Block> logs = tag(BlockTags.LOGS);
        IntrinsicTagAppender<Block> fences = tag(BlockTags.WOODEN_FENCES);
        IntrinsicTagAppender<Block> fenceGates = tag(BlockTags.FENCE_GATES);
        IntrinsicTagAppender<Block> doors = tag(BlockTags.WOODEN_DOORS);
        IntrinsicTagAppender<Block> trapdoors = tag(BlockTags.WOODEN_TRAPDOORS);
        IntrinsicTagAppender<Block> buttons = tag(BlockTags.WOODEN_BUTTONS);
        IntrinsicTagAppender<Block> pressurePlates = tag(BlockTags.WOODEN_PRESSURE_PLATES);
        IntrinsicTagAppender<Block> slabs = tag(BlockTags.WOODEN_SLABS);
        IntrinsicTagAppender<Block> stairs = tag(BlockTags.WOODEN_STAIRS);
        IntrinsicTagAppender<Block> standingSigns = tag(BlockTags.STANDING_SIGNS);
        IntrinsicTagAppender<Block> wallSigns = tag(BlockTags.WALL_SIGNS);
        IntrinsicTagAppender<Block> wallHangingSigns = tag(BlockTags.WALL_HANGING_SIGNS);
        IntrinsicTagAppender<Block> ceilingHangingSigns = tag(BlockTags.CEILING_HANGING_SIGNS);

        for (PetalBlock petalBlock : ModBlocks.getPetalBlocks().toList()) {
            petalBlocks.add(petalBlock);
        }

        mineableWithHoe.addTag(ModBlockTags.PETAL_BLOCKS);
        logs.addTag(ModBlockTags.STEMS);

        planks.add(ModBlocks.STEM_PLANKS.get());
        stems.add(ModBlocks.STEM.get());
        fences.add(ModBlocks.STEM_FENCE.get());
        fenceGates.add(ModBlocks.STEM_FENCE_GATE.get());
        doors.add(ModBlocks.STEM_DOOR.get());
        trapdoors.add(ModBlocks.STEM_TRAPDOOR.get());
        buttons.add(ModBlocks.STEM_BUTTON.get());
        pressurePlates.add(ModBlocks.STEM_PRESSURE_PLATE.get());
        slabs.add(ModBlocks.STEM_SLAB.get());
        stairs.add(ModBlocks.STEM_STAIRS.get());
        standingSigns.add(ModBlocks.STEM_SIGN.get());
        wallSigns.add(ModBlocks.STEM_WALL_SIGN.get());
        wallHangingSigns.add(ModBlocks.STEM_WALL_HANGING_SIGN.get());
        ceilingHangingSigns.add(ModBlocks.STEM_HANGING_SIGN.get());
    }
}
