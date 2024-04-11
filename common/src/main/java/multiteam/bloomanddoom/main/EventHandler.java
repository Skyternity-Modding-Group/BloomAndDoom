package multiteam.bloomanddoom.main;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.InteractionEvent;
import multiteam.bloomanddoom.main.growable_flower.GrowableFlower;
import multiteam.bloomanddoom.main.growable_flower.GrowableFlowerRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class EventHandler {
    public static void init() {
        InteractionEvent.RIGHT_CLICK_BLOCK.register(EventHandler::onBonemealUsed);
    }

    private static EventResult onBonemealUsed(Player player, InteractionHand interactionHand, BlockPos blockPos, Direction direction) {
        Level level = player.level();
        Block block = level.getBlockState(blockPos).getBlock();
        ItemStack handStack = player.getItemInHand(interactionHand);

        if (!handStack.is(Items.BONE_MEAL)) {
            return EventResult.pass();
        }

        // If player has used bonemeal on a block then,
        GrowableFlower flower = GrowableFlowerRegistry.doesRegistryContainThisFlower(block);
        if (flower == null) {
            return EventResult.pass();
        }

        // we detect if the block is a growable flower
        // TODO implement growable flower registry so we don't have to test for each flower and that way its also moddable
        if (level instanceof ServerLevel serverLevel) { //B, grow flower aka place flower stem and petal blocks on server side
            flower.growAt(blockPos, serverLevel, level.random, GrowableFlower.GrowMethod.DROP_IF_OCCUPIED);
        } else { //then we A, spawn particles on clientside
            level.blockEvent(blockPos, block, 0, 0);
        }

        return EventResult.interruptDefault();
    }
}
