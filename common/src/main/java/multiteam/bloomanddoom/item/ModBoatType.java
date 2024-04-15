package multiteam.bloomanddoom.item;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mojang.serialization.Codec;
import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.init.References;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.ArrayUtils;

public record ModBoatType(Block planks, String name, ResourceLocation registryName) {
    private static ModBoatType[] values = new ModBoatType[0];
    private static BiMap<ResourceLocation, ModBoatType> REGISTRY = HashBiMap.create();
    public static final ModBoatType STEM = new ModBoatType(ModBlocks.STEM.get(), "stem");

    public static final Codec<ModBoatType> CODEC = ResourceLocation.CODEC.xmap(ModBoatType::byResourceLocation, ModBoatType::getRegistryName);

    private static ModBoatType byResourceLocation(ResourceLocation resourceLocation) {
        return REGISTRY.get(resourceLocation);
    }

    private ResourceLocation getRegistryName() {
        return REGISTRY.inverse().get(this);
    }

    private static ModBoatType[] values() {
        return values;
    }

    public ModBoatType(Block planks, String name) {
        this(planks, name, new ResourceLocation(References.MOD_ID, name));
    }

    public ModBoatType(Block planks, String name, ResourceLocation registryName) {
        this.name = name;
        this.planks = planks;
        this.registryName = registryName;

        values = ArrayUtils.add(values, this);
    }

    public String getSerializedName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    @Deprecated
    public static ModBoatType byName(String name) {
        return REGISTRY.get(new ResourceLocation(name));
    }

    public static ModBoatType byId(int id) {
        return values[id];
    }

    public int getId() {
        return ArrayUtils.indexOf(values, this);
    }
}
