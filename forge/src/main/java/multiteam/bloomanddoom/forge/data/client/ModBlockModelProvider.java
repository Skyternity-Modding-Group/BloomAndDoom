package multiteam.bloomanddoom.forge.data.client;

import multiteam.bloomanddoom.init.References;
import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockStateProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, References.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void registerStatesAndModels() {
        for (var petalBlock : ModBlocks.getPetalBlocks().toList()) {
            simpleBlock(petalBlock);
        }

        logBlock(ModBlocks.STEM.get());
        logBlock(ModBlocks.STRIPPED_STEM.get());

        simpleBlock(ModBlocks.STEM_PLANKS.get());
        simpleBlock(ModBlocks.STEM_BUNDLE.get(), models().cubeAll("stem_bundle", References.res("block/stem")));
        simpleBlock(ModBlocks.STRIPPED_STEM_BUNDLE.get(), models().cubeAll("stripped_stem_bundle", References.res("block/stripped_stem")));

        slabBlock(ModBlocks.STEM_SLAB.get(), References.res("block/stem_planks"), References.res("block/stem_planks"));
        stairsBlock(ModBlocks.STEM_STAIRS.get(), References.res("block/stem_planks"));

        doorBlock(ModBlocks.STEM_DOOR.get(), References.res("block/stem_door_bottom"), References.res("block/stem_door_top"));
        trapdoorBlock(ModBlocks.STEM_TRAPDOOR.get(), References.res("block/stem_trapdoor"), true);

        fenceBlock(ModBlocks.STEM_FENCE.get(), References.res("block/stem_planks"));
        fenceGateBlock(ModBlocks.STEM_FENCE_GATE.get(), References.res("block/stem_planks"));

        buttonBlock(ModBlocks.STEM_BUTTON.get(), References.res("block/stem_planks"));
        pressurePlateBlock(ModBlocks.STEM_PRESSURE_PLATE.get(), References.res("block/stem_planks"));

        signBlock(ModBlocks.STEM_SIGN.get(), ModBlocks.STEM_WALL_SIGN.get(), References.res("block/stem_planks"));

        ModelFile sign = models().sign("stem_hanging_sign", References.res("block/stem_planks"));
        simpleBlock(ModBlocks.STEM_HANGING_SIGN.get(), sign);
        simpleBlock(ModBlocks.STEM_WALL_HANGING_SIGN.get(), sign);

        itemModels().basicItem(ModItems.STEM_SIGN.get());
        itemModels().basicItem(ModItems.STEM_HANGING_SIGN.get());

        for (BlockItem blockItem : ModItems.getBlockItems().toList()) {
            ResourceLocation key = BuiltInRegistries.BLOCK.getKey(blockItem.getBlock());

            if (blockItem.getBlock() instanceof DoorBlock) {
                itemModels().basicItem(blockItem);
                continue;
            }

            if (blockItem.getBlock() instanceof TrapDoorBlock) {
                itemModels().withExistingParent(key.getPath(), new ResourceLocation(key.getNamespace(), "block/" + key.getPath() + "_bottom"));
                continue;
            }

            if (blockItem.getBlock() instanceof FenceBlock) {
                models().fenceInventory("stem_fence_inventory", References.res("block/stem_planks"));
                itemModels().withExistingParent(key.getPath(), new ResourceLocation(key.getNamespace(), "block/" + key.getPath() + "_inventory"));
                continue;
            }

            if (blockItem.getBlock() instanceof ButtonBlock) {
                models().buttonInventory("stem_button_inventory", References.res("block/stem_planks"));
                itemModels().withExistingParent(key.getPath(), new ResourceLocation(key.getNamespace(), "block/" + key.getPath() + "_inventory"));
            }

            itemModels().withExistingParent(key.getPath(), new ResourceLocation(key.getNamespace(), "block/" + key.getPath()));
        }

        itemModels().basicItem(ModItems.STEM_BOAT.get());
        itemModels().basicItem(ModItems.STEM_CHEST_BOAT.get());
    }
}
