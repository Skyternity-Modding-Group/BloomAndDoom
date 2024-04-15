package multiteam.bloomanddoom.entity;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.registry.Registration;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;

public class ModEntityTypes {
    public static final RegistrySupplier<EntityType<Boat>> STEM_BOAT = Registration.ENTITY_TYPES.register("stem_boat", () -> EntityType.Builder.<Boat>of(StemBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("bloom_and_doom:stem_boat"));
    public static final RegistrySupplier<EntityType<Boat>> STEM_CHEST_BOAT = Registration.ENTITY_TYPES.register("stem_chest_boat", () -> EntityType.Builder.<Boat>of(StemChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build("bloom_and_doom:stem_chest_boat"));

    public static void init() {
        // NO-OP
    }
}
