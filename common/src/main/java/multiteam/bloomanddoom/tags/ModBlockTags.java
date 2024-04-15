package multiteam.bloomanddoom.tags;

import multiteam.bloomanddoom.init.References;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
    public static final TagKey<Block> PETAL_BLOCKS = create("petal_blocks");
    public static final TagKey<Block> STEMS = create("stems");

    private static TagKey<Block> create(String name) {
        return TagKey.create(Registries.BLOCK, References.res(name));
    }

    private static TagKey<Block> createMc(String name) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, name));
    }

    public static void init() {

    }
}
