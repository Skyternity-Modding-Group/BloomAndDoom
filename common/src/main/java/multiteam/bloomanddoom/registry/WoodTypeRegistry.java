package multiteam.bloomanddoom.registry;

import com.google.common.collect.Lists;
import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.objectweb.asm.commons.InstructionAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WoodTypeRegistry {
    private static final List<WoodType> customWoodTypes = new ArrayList<>();

    public static void register(WoodType woodType) {
        customWoodTypes.add(woodType);
    }

    public static List<WoodType> getCustomWoodTypes() {
        return Collections.unmodifiableList(customWoodTypes);
    }

    @ExpectPlatform
    public static void registerWoodTypes() {
        throw new AssertionError();
    }
}
