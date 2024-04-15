package multiteam.bloomanddoom.growableflower;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.BloomAndDoom;
import multiteam.bloomanddoom.registry.Registration;
import multiteam.bloomanddoom.util.StructureTemplateFactory;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.joml.Vector3d;
import oshi.util.tuples.Pair;

public class GrowableFlowerRegistry {
    public static final RegistrySupplier<StructureGrowableFlower> DANDELION = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("dandelion"),
            () -> new StructureGrowableFlower(Blocks.DANDELION, StructureTemplateFactory.of(BloomAndDoom.res("dandelion")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> POPPY = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("poppy"),
            () -> new StructureGrowableFlower(Blocks.POPPY, StructureTemplateFactory.of(BloomAndDoom.res("poppy")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> BLUE_ORCHID = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("blue_orchid"),
            () -> new StructureGrowableFlower(Blocks.BLUE_ORCHID, StructureTemplateFactory.of(BloomAndDoom.res("blue_orchid")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> ALLIUM = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("allium"),
            () -> new StructureGrowableFlower(Blocks.ALLIUM, StructureTemplateFactory.of(BloomAndDoom.res("allium")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> AZURE_BLUET = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("azure_bluet"),
            () -> new StructureGrowableFlower(Blocks.AZURE_BLUET, StructureTemplateFactory.of(BloomAndDoom.res("azure_bluet")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> RED_TULIP = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("red_tulip"),
            () -> new StructureGrowableFlower(Blocks.RED_TULIP, StructureTemplateFactory.of(BloomAndDoom.res("red_tulip")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> ORANGE_TULIP = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("orange_tulip"),
            () -> new StructureGrowableFlower(Blocks.ORANGE_TULIP, StructureTemplateFactory.of(BloomAndDoom.res("orange_tulip")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> WHITE_TULIP = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("white_tulip"),
            () -> new StructureGrowableFlower(Blocks.WHITE_TULIP, StructureTemplateFactory.of(BloomAndDoom.res("white_tulip")))
    );

    public static final RegistrySupplier<StructureGrowableFlower> PINK_TULIP = Registration.GROWABLE_FLOWER.register(
            BloomAndDoom.res("pink_tulip"),
            () -> new StructureGrowableFlower(Blocks.PINK_TULIP, StructureTemplateFactory.of(BloomAndDoom.res("pink_tulip")))
    );

    public static void init() {

    }

    public static GrowableFlower doesRegistryContainThisFlower(Block flower) {
        for (GrowableFlower growable : Registration.GROWABLE_FLOWER) {
            if (growable.getFlower() == flower)
                return growable;
        }
        return null;
    }

    private static Pair<BlockState, Vector3d> block(Block block, double x, double y, double z) {
        return new Pair<>(block.defaultBlockState(), new Vector3d(x, y, z));
    }
}
