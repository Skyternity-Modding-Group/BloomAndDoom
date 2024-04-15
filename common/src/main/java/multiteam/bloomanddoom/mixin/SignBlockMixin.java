package multiteam.bloomanddoom.mixin;

import multiteam.bloomanddoom.block.entity.CustomSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignApplicator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
@Mixin(SignBlock.class)
public abstract class SignBlockMixin {
    @Shadow
    public abstract void openTextEdit(Player player, SignBlockEntity signBlockEntity, boolean bl);

    @Shadow
    protected abstract boolean otherPlayerIsEditingSign(Player player, SignBlockEntity signBlockEntity);

    @Shadow
    protected abstract boolean hasEditableText(Player player, SignBlockEntity signBlockEntity, boolean bl);

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void sign$use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit, CallbackInfoReturnable<InteractionResult> cir) {
        if (level.getBlockEntity(pos) instanceof CustomSignBlockEntity) {
            cir.setReturnValue(this.bloomAndDoom$use(level, pos, player, hand));
        }
    }


    @Unique
    public InteractionResult bloomAndDoom$use(Level level, BlockPos pos, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        Item item = itemStack.getItem();
        SignApplicator applicator;
        if (item instanceof SignApplicator signApplicator) {
            applicator = signApplicator;
        } else {
            applicator = null;
        }

        SignApplicator signApplicator = applicator;
        boolean justABoolean = signApplicator != null && player.mayBuild();
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof CustomSignBlockEntity signBlockEntity) {
            if (!level.isClientSide) {
                boolean facingFrontText = signBlockEntity.isFacingFrontText(player);
                SignText signText = signBlockEntity.getText(facingFrontText);
                boolean clickSuccess = signBlockEntity.executeClickCommandsIfPresent(player, level, pos, facingFrontText);
                if (signBlockEntity.isWaxed()) {
                    level.playSound(null, signBlockEntity.getBlockPos(), SoundEvents.WAXED_SIGN_INTERACT_FAIL, SoundSource.BLOCKS);
                    return InteractionResult.PASS;
                } else if (justABoolean && !this.otherPlayerIsEditingSign(player, signBlockEntity) && signApplicator.canApplyToSign(signText, player) && signApplicator.tryApplyToSign(level, signBlockEntity, facingFrontText, player)) {
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }

                    level.gameEvent(GameEvent.BLOCK_CHANGE, signBlockEntity.getBlockPos(), GameEvent.Context.of(player, signBlockEntity.getBlockState()));
                    player.awardStat(Stats.ITEM_USED.get(item));
                    return InteractionResult.SUCCESS;
                } else if (clickSuccess) {
                    return InteractionResult.SUCCESS;
                } else if (!this.otherPlayerIsEditingSign(player, signBlockEntity) && player.mayBuild() && this.hasEditableText(player, signBlockEntity, facingFrontText)) {
                    this.openTextEdit(player, signBlockEntity, facingFrontText);
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.PASS;
                }
            } else {
                return !justABoolean && !signBlockEntity.isWaxed() ? InteractionResult.CONSUME : InteractionResult.SUCCESS;
            }
        } else {
            return InteractionResult.PASS;
        }
    }
}