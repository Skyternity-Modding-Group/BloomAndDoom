package multiteam.bloomanddoom.registry.fabric;

import multiteam.bloomanddoom.BloomAndDoom;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.List;

import static multiteam.bloomanddoom.registry.BlockSetTypeRegistry.getCustomBlockSetTypes;

public class BlockSetTypeRegistryImpl {
    public static void registerBlockSetTypes() {
        List<BlockSetType> customBlockSetTypes = getCustomBlockSetTypes();
        for (BlockSetType customBlockSetType : customBlockSetTypes) {
            BlockSetTypeBuilder.copyOf(customBlockSetType).register(new ResourceLocation(customBlockSetType.name()));
        }
    }
}
