package multiteam.bloomanddoom.forge.data.client;

import multiteam.bloomanddoom.References;
import multiteam.bloomanddoom.main.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, References.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var block : ModBlocks.getAllBlocks().toList()) {

        }
    }
}
