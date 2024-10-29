package thebendy.bdsmapi.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;

public class CustomGeoBlockEntity extends CustomBlockEntity implements GeoBlockEntity {
    protected final AnimatableInstanceCache ANIMATION_CACHE;
    protected RawAnimation animation;

    public CustomGeoBlockEntity(BlockEntityType<? extends CustomGeoBlockEntity> type, BlockPos pos, BlockState state, RawAnimation rawAnimation) {
        super(type, pos, state);
        this.ANIMATION_CACHE = GeckoLibUtil.createInstanceCache(this);
        this.animation = rawAnimation;
    }

    public RawAnimation getAnimation() {
        return animation;
    }

    public void setAnimation(RawAnimation rawAnimation) {
        this.animation = Objects.requireNonNullElseGet(rawAnimation, RawAnimation::begin);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, animationState -> animationState.setAndContinue(animation)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return ANIMATION_CACHE;
    }
}
