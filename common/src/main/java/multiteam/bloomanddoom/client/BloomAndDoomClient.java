package multiteam.bloomanddoom.client;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import multiteam.bloomanddoom.block.ModBlocks;
import multiteam.bloomanddoom.block.entity.ModBlockEntityTypes;
import multiteam.bloomanddoom.client.renderer.StemBoatRenderer;
import multiteam.bloomanddoom.client.renderer.block.CustomHangingSignRenderer;
import multiteam.bloomanddoom.client.renderer.block.CustomSignRenderer;
import multiteam.bloomanddoom.entity.ModEntityTypes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class BloomAndDoomClient {
    public void init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(this::clientSetup);

        if (Platform.isFabric()) {
            RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.STEM_DOOR.get());
            RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.STEM_TRAPDOOR.get());
            RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.THORNY_STEM.get());

            EntityRendererRegistry.register(ModEntityTypes.STEM_BOAT, context -> new StemBoatRenderer(context, false));
            EntityRendererRegistry.register(ModEntityTypes.STEM_CHEST_BOAT, context -> new StemBoatRenderer(context, true));

            BlockEntityRendererRegistry.register(ModBlockEntityTypes.CUSTOM_SIGN.get(), SignRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntityTypes.CUSTOM_HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }

    private void clientSetup(Minecraft minecraft) {
        // Do client stuff
        if (Platform.isForge()) {
            RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.STEM_DOOR.get());
            RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.STEM_TRAPDOOR.get());
            RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.THORNY_STEM.get());

            EntityRendererRegistry.register(ModEntityTypes.STEM_BOAT, context -> new StemBoatRenderer(context, false));
            EntityRendererRegistry.register(ModEntityTypes.STEM_CHEST_BOAT, context -> new StemBoatRenderer(context, true));

            BlockEntityRendererRegistry.register(ModBlockEntityTypes.CUSTOM_SIGN.get(), SignRenderer::new);
            BlockEntityRendererRegistry.register(ModBlockEntityTypes.CUSTOM_HANGING_SIGN.get(), HangingSignRenderer::new);
        }
    }
}
