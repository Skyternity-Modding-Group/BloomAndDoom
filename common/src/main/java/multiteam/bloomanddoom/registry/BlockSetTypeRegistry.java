package multiteam.bloomanddoom.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockSetTypeRegistry {
    private static final List<BlockSetType> customBlockSetTypes = new ArrayList<>();

    public static void register(BlockSetType blockSetType) {
        customBlockSetTypes.add(blockSetType);
    }

    public static List<BlockSetType> getCustomBlockSetTypes() {
        return Collections.unmodifiableList(customBlockSetTypes);
    }

    @ExpectPlatform
    public static void registerBlockSetTypes() {
        throw new AssertionError();
    }
}
