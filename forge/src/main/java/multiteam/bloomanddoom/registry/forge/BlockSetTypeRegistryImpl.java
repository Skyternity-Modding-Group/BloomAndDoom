package multiteam.bloomanddoom.registry.forge;

import multiteam.bloomanddoom.registry.BlockSetTypeRegistry;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class BlockSetTypeRegistryImpl {
    public static void registerBlockSetTypes() {
        for (BlockSetType customBlockSetType : BlockSetTypeRegistry.getCustomBlockSetTypes()) {
            BlockSetType.register(customBlockSetType);
        }
    }
}
