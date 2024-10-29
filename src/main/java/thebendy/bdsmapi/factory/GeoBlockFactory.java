package thebendy.bdsmapi.factory;

import net.minecraft.block.BlockRenderType;
import software.bernie.geckolib.core.animation.RawAnimation;

public class GeoBlockFactory extends BlockWithEntityFactory {
    protected RawAnimation animation;

    public GeoBlockFactory() {
        this.BLOCK_SETTINGS.blockRenderType(BlockRenderType.ENTITYBLOCK_ANIMATED);
    }

    public void setAnimation(RawAnimation rawAnimation) {
        this.animation = rawAnimation;
    }
}
