package multiteam.bloomanddoom.forge.data.client;

import multiteam.bloomanddoom.References;
import multiteam.bloomanddoom.main.block.ModBlocks;
import multiteam.bloomanddoom.main.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.sql.Ref;

public class ModBlockModelProvider extends BlockStateProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, References.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (var petalBlock : ModBlocks.getPetalBlocks().toList()) {
            simpleBlock(petalBlock);
        }

        logBlock(ModBlocks.FLOWER_STEM.get());
        logBlock(ModBlocks.STRIPPED_FLOWER_STEM.get());

        simpleBlock(ModBlocks.FLOWER_PLANKS.get());

        slabBlock(ModBlocks.FLOWER_PLANKS_SLAB.get(), References.res("block/stem_planks"), References.res("block/stem_planks"));
        stairsBlock(ModBlocks.FLOWER_PLANKS_STAIRS.get(), References.res("block/stem_planks"));

        for (BlockItem blockItem : ModItems.getBlockItems().toList()) {
            ResourceLocation key = BuiltInRegistries.BLOCK.getKey(blockItem.getBlock());
            itemModels().withExistingParent(key.getPath(), new ResourceLocation(key.getNamespace(), "block/" + key.getPath()));
        }
    }
}
