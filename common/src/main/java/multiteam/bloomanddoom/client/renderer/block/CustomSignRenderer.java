package multiteam.bloomanddoom.client.renderer.block;

import multiteam.bloomanddoom.block.entity.CustomSignBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class CustomSignRenderer extends SignRenderer {
    public CustomSignRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }
}
