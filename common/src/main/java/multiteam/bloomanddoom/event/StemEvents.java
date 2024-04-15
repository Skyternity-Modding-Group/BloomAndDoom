package multiteam.bloomanddoom.event;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

/**
 * For those who like to have to do something when a stem got stripped, I guess 🤷.
 */
public class StemEvents {
    public static final Event<StemStripped> STEM_STRIPPED = EventFactory.createLoop();

    @FunctionalInterface
    public interface StemStripped {
        void onStemStripped(BlockPos position, BlockState state, ItemStack usedItem);
    }
}
