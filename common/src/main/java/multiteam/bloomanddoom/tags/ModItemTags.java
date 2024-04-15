package multiteam.bloomanddoom.tags;

import multiteam.bloomanddoom.init.References;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> PETAL_ITEMS = create("petal_items");
    public static final TagKey<Item> STEMS = create("stems");


    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, References.res(name));
    }

    private static TagKey<Item> createMc(String name) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, name));
    }

    public static void init() {

    }
}
