package multiteam.bloomanddoom.init;

import net.minecraft.resources.ResourceLocation;

public class References {
    public static final String MOD_ID = "bloom_and_doom";

    public static ResourceLocation res(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
