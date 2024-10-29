package thebendy.bdsmapi.custom;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CustomBlockWithEntity<T extends CustomBlockEntity> extends CustomBlock implements BlockEntityProvider {
    public final BlockEntityType<T> BLOCK_ENTITY_TYPE;

    public CustomBlockWithEntity(CustomBlockSettings settings) {
        super(settings);
        this.BLOCK_ENTITY_TYPE = BlockEntityType.Builder.create(this::createBlockEntity, this).build();
    }

    @Override
    public boolean onSyncedBlockEvent(BlockState state, World world, BlockPos pos, int type, int data) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity != null && blockEntity.onSyncedBlockEvent(type, data);
    }

    @Nullable
    @Override
    public NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        return blockEntity instanceof NamedScreenHandlerFactory ? (NamedScreenHandlerFactory)blockEntity : null;
    }

    @Override
    public T createBlockEntity(BlockPos pos, BlockState state) {
        return (T) new CustomBlockEntity(BLOCK_ENTITY_TYPE, pos, state);
    }
}
