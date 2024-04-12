package multiteam.bloomanddoom.main.block;

import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public class FlowerStemBlock extends RotatedPillarBlock {
    protected FlowerStemBlock() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).sound(SoundType.STEM).instrument(NoteBlockInstrument.BANJO).strength(2.0F, 3.0F).ignitedByLava());
    }
}
