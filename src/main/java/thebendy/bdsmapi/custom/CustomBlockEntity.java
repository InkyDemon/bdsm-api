package thebendy.bdsmapi.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class CustomBlockEntity extends BlockEntity {
    protected NbtCompound nbt;

    public CustomBlockEntity(BlockEntityType<? extends CustomBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
        this.nbt = new NbtCompound();
    }

    public NbtCompound getNbt() {
        return nbt;
    }

    public void setNbt(NbtCompound nbtCompound) {
        this.nbt = Objects.requireNonNullElseGet(nbtCompound, NbtCompound::new);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        this.nbt = nbt;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        this.nbt.getKeys().forEach(s -> nbt.put(s, this.nbt.get(s)));
    }
}
