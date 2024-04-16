package multiteam.bloomanddoom.forge.data;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.bloomanddoom.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {
    public ModLootTableProvider(PackOutput arg) {
        super(arg, Set.of(), List.of(
                new SubProviderEntry(ModBlockLoot::new, LootContextParamSet.builder().required(LootContextParams.EXPLOSION_RADIUS).required(LootContextParams.BLOCK_STATE).required(LootContextParams.ORIGIN).build())
        ));
    }

    @Override
    public @NotNull List<SubProviderEntry> getTables() {
        return super.getTables();
    }

    public static class ModBlockLoot extends BlockLootSubProvider {
        protected ModBlockLoot() {
            super(Set.of(), FeatureFlags.VANILLA_SET);
        }

        @Override
        protected void generate() {
            List<RegistrySupplier<Block>> list = ModBlocks.getAllBlocks().toList();
            for (RegistrySupplier<Block> reg : list) {
                Block block = reg.get();

                if (block instanceof DoorBlock) this.add(block, this.createDoorTable(block));
                else dropSelf(block);
            }
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ModBlocks.getAllBlocks().toList().stream().map(RegistrySupplier::get).toList();
        }
    }
}