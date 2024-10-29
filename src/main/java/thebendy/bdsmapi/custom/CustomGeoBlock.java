package thebendy.bdsmapi.custom;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.core.animation.RawAnimation;

public class CustomGeoBlock extends CustomBlockWithEntity<CustomGeoBlockEntity> {
    protected final RawAnimation ANIMATION;

    public CustomGeoBlock(CustomBlockSettings settings, RawAnimation rawAnimation) {
        super(settings);
        this.ANIMATION = rawAnimation;
    }

    @Override
    public CustomGeoBlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CustomGeoBlockEntity(BLOCK_ENTITY_TYPE, pos, state, ANIMATION);
    }
}
