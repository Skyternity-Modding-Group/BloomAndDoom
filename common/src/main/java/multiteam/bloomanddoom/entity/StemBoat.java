package multiteam.bloomanddoom.entity;

import multiteam.bloomanddoom.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class StemBoat extends Boat implements IStemBoat {
    public StemBoat(EntityType<Boat> entityType, Level level) {
        super(entityType, level);
    }

    public StemBoat(Level level, double x, double y, double z) {
        this(ModEntityTypes.STEM_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public @NotNull Type getVariant() {
        return Type.OAK;
    }

    @Override
    public void setVariant(Type type) {
        // NO!
    }

    @Override
    public @NotNull Item getDropItem() {
        return ModItems.STEM_BOAT.get();
    }
}
