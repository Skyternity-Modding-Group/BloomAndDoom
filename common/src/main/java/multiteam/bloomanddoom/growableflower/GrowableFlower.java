package multiteam.bloomanddoom.growableflower;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public abstract class GrowableFlower {
    private final Block flower;

    public GrowableFlower(Block flower) {
        this.flower = flower;
    }

    public Block getFlower() {
        return this.flower;
    }

    public abstract void growAt(BlockPos basePos, ServerLevelAccessor levelAccessor, RandomSource random, @NotNull StructureGrowableFlower.GrowMethod method);

    public enum GrowMethod {
        DEFAULT,
        DROP_IF_OCCUPIED;

        public static final Codec<GrowMethod> CODEC = Codec.STRING.xmap(name -> GrowMethod.valueOf(name.toUpperCase(Locale.ROOT)), method -> method.name().toLowerCase(Locale.ROOT));
    }
}
