package multiteam.bloomanddoom.entity;

import multiteam.bloomanddoom.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class StemChestBoat extends ChestBoat {
    public StemChestBoat(EntityType<? extends Boat> entityType, Level level) {
        super(entityType, level);
    }

    public StemChestBoat(Level level, double x, double y, double z) {
        this(ModEntityTypes.STEM_CHEST_BOAT.get(), level);
        this.setPos(x, y, z);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    @Override
    public Item getDropItem() {
        return ModItems.STEM_CHEST_BOAT.get();
    }
}
