package multiteam.bloomanddoom.main.util;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

@FunctionalInterface
public interface StructureTemplateFactory {
    StructureTemplate create(MinecraftServer server);

    static StructureTemplateFactory of(ResourceLocation id) {
        return (server) -> server.getStructureManager().getOrCreate(id);
    }
}
