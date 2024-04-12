package multiteam.bloomanddoom.main.block;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class PetalBlock extends Block {
    private final DyeColor color;

    public PetalBlock(DyeColor color) {
        super(BlockBehaviour.Properties.of().mapColor(color.getMapColor()).sound(SoundType.WART_BLOCK).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava());

        this.color = color;
    }

    public DyeColor getColor() {
        return color;
    }
}
