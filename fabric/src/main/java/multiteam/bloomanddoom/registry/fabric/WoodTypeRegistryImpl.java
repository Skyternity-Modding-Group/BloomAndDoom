package multiteam.bloomanddoom.registry.fabric;

import multiteam.bloomanddoom.BloomAndDoom;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.List;

import static multiteam.bloomanddoom.registry.WoodTypeRegistry.*;

public class WoodTypeRegistryImpl {
    public static void registerWoodTypes() {
        List<WoodType> customWoodTypes = getCustomWoodTypes();
        for (WoodType customWoodType : customWoodTypes) {
            WoodTypeBuilder.copyOf(customWoodType).register(new ResourceLocation(customWoodType.name()), customWoodType.setType());
        }
    }
}
