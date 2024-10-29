package thebendy.bdsmapi.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import thebendy.bdsmapi.event.BlockEvents;
import thebendy.bdsmapi.event.block.OnUse;

import java.util.function.Function;
import java.util.function.ToIntFunction;

public class CustomBlock extends Block {
    protected final BlockEvents BLOCK_EVENTS;
    protected BlockRenderType blockRenderType;
    protected VoxelShape voxelShape;

    public CustomBlock(CustomBlockSettings settings) {
        super(settings);
        this.voxelShape = settings.voxelShape;
        this.blockRenderType = settings.blockRenderType;
        this.BLOCK_EVENTS = settings.BLOCK_EVENTS;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BLOCK_EVENTS.onUse.event(state, world, pos, player, hand, hit);
        return ActionResult.PASS;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return blockRenderType;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return voxelShape;
    }

    public static class CustomBlockSettings extends FabricBlockSettings {
        protected final BlockEvents BLOCK_EVENTS;
        protected BlockRenderType blockRenderType;
        protected VoxelShape voxelShape;

        protected CustomBlockSettings(AbstractBlock.Settings settings) {
            super(settings);
            this.voxelShape = VoxelShapes.fullCube();
            this.BLOCK_EVENTS = new BlockEvents();
            this.blockRenderType = BlockRenderType.MODEL;
        }

        public static CustomBlockSettings create() {
            return new CustomBlockSettings(AbstractBlock.Settings.create());
        }

        /**
         * @deprecated
         */
        @Deprecated
        public static CustomBlockSettings of() {
            return create();
        }

        public static CustomBlockSettings copyOf(AbstractBlock block) {
            return new CustomBlockSettings(block.getSettings());
        }

        public static CustomBlockSettings copyOf(AbstractBlock.Settings settings) {
            return new CustomBlockSettings(settings);
        }

        public CustomBlockSettings blockRenderType(BlockRenderType blockRenderType) {
            this.blockRenderType = blockRenderType;
            return this;
        }

        public CustomBlockSettings onUse(OnUse onUse) {
            this.BLOCK_EVENTS.onUse = onUse;
            return this;
        }

        public CustomBlockSettings voxelShape(VoxelShape voxelShape) {
            this.voxelShape = voxelShape;
            return this;
        }

        public CustomBlockSettings noCollision() {
            super.noCollision();
            return this;
        }

        public CustomBlockSettings nonOpaque() {
            super.nonOpaque();
            return this;
        }

        public CustomBlockSettings slipperiness(float value) {
            super.slipperiness(value);
            return this;
        }

        public CustomBlockSettings velocityMultiplier(float velocityMultiplier) {
            super.velocityMultiplier(velocityMultiplier);
            return this;
        }

        public CustomBlockSettings jumpVelocityMultiplier(float jumpVelocityMultiplier) {
            super.jumpVelocityMultiplier(jumpVelocityMultiplier);
            return this;
        }

        public CustomBlockSettings sounds(BlockSoundGroup group) {
            super.sounds(group);
            return this;
        }

        /**
         * @deprecated
         */
        @Deprecated
        public CustomBlockSettings lightLevel(ToIntFunction<BlockState> levelFunction) {
            return this.luminance(levelFunction);
        }

        public CustomBlockSettings luminance(ToIntFunction<BlockState> luminanceFunction) {
            super.luminance(luminanceFunction);
            return this;
        }

        public CustomBlockSettings strength(float hardness, float resistance) {
            super.strength(hardness, resistance);
            return this;
        }

        public CustomBlockSettings breakInstantly() {
            super.breakInstantly();
            return this;
        }

        public CustomBlockSettings strength(float strength) {
            super.strength(strength);
            return this;
        }

        public CustomBlockSettings ticksRandomly() {
            super.ticksRandomly();
            return this;
        }

        public CustomBlockSettings dynamicBounds() {
            super.dynamicBounds();
            return this;
        }

        public CustomBlockSettings dropsNothing() {
            super.dropsNothing();
            return this;
        }

        public CustomBlockSettings dropsLike(Block block) {
            super.dropsLike(block);
            return this;
        }

        public CustomBlockSettings air() {
            super.air();
            return this;
        }

        public CustomBlockSettings allowsSpawning(AbstractBlock.TypedContextPredicate<EntityType<?>> predicate) {
            super.allowsSpawning(predicate);
            return this;
        }

        public CustomBlockSettings solidBlock(AbstractBlock.ContextPredicate predicate) {
            super.solidBlock(predicate);
            return this;
        }

        public CustomBlockSettings suffocates(AbstractBlock.ContextPredicate predicate) {
            super.suffocates(predicate);
            return this;
        }

        public CustomBlockSettings blockVision(AbstractBlock.ContextPredicate predicate) {
            super.blockVision(predicate);
            return this;
        }

        public CustomBlockSettings postProcess(AbstractBlock.ContextPredicate predicate) {
            super.postProcess(predicate);
            return this;
        }

        public CustomBlockSettings emissiveLighting(AbstractBlock.ContextPredicate predicate) {
            super.emissiveLighting(predicate);
            return this;
        }

        public CustomBlockSettings requiresTool() {
            super.requiresTool();
            return this;
        }

        public CustomBlockSettings mapColor(MapColor color) {
            super.mapColor(color);
            return this;
        }

        public CustomBlockSettings hardness(float hardness) {
            super.hardness(hardness);
            return this;
        }

        public CustomBlockSettings resistance(float resistance) {
            super.resistance(resistance);
            return this;
        }

        public CustomBlockSettings offset(AbstractBlock.OffsetType offsetType) {
            super.offset(offsetType);
            return this;
        }

        public CustomBlockSettings noBlockBreakParticles() {
            super.noBlockBreakParticles();
            return this;
        }

        public CustomBlockSettings requires(FeatureFlag... features) {
            super.requires(features);
            return this;
        }

        public CustomBlockSettings mapColor(Function<BlockState, MapColor> mapColorProvider) {
            super.mapColor(mapColorProvider);
            return this;
        }

        public CustomBlockSettings burnable() {
            super.burnable();
            return this;
        }

        public CustomBlockSettings liquid() {
            super.liquid();
            return this;
        }

        public CustomBlockSettings solid() {
            super.solid();
            return this;
        }

        public CustomBlockSettings notSolid() {
            super.notSolid();
            return this;
        }

        public CustomBlockSettings pistonBehavior(PistonBehavior pistonBehavior) {
            super.pistonBehavior(pistonBehavior);
            return this;
        }

        public CustomBlockSettings instrument(Instrument instrument) {
            super.instrument(instrument);
            return this;
        }

        public CustomBlockSettings replaceable() {
            super.replaceable();
            return this;
        }

        /**
         * @deprecated
         */
        @Deprecated
        public CustomBlockSettings lightLevel(int lightLevel) {
            this.luminance(lightLevel);
            return this;
        }

        public CustomBlockSettings luminance(int luminance) {
            this.luminance((ignored) -> {
                return luminance;
            });
            return this;
        }

        public CustomBlockSettings drops(Identifier dropTableId) {
            super.drops(dropTableId);
            return this;
        }

        /**
         * @deprecated
         */
        @Deprecated
        public CustomBlockSettings materialColor(MapColor color) {
            return this.mapColor(color);
        }

        /**
         * @deprecated
         */
        @Deprecated
        public CustomBlockSettings materialColor(DyeColor color) {
            return this.mapColor(color);
        }

        public CustomBlockSettings mapColor(DyeColor color) {
            return this.mapColor(color.getMapColor());
        }

        public CustomBlockSettings collidable(boolean collidable) {
            super.collidable(collidable);
            return this;
        }
    }
}