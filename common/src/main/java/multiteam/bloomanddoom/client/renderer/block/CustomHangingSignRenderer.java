package multiteam.bloomanddoom.client.renderer.block;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;

public class CustomHangingSignRenderer extends HangingSignRenderer {
    public CustomHangingSignRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }
}
