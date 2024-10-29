package thebendy.bdsmapi.factory;

import net.minecraft.item.Item;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import thebendy.bdsmapi.custom.CustomBlock;

import java.util.Arrays;

public class BlockFactory {
    protected final CustomBlock.CustomBlockSettings BLOCK_SETTINGS;
    protected final Item.Settings BLOCK_ITEM_SETTINGS;

    public BlockFactory() {
        this.BLOCK_SETTINGS = CustomBlock.CustomBlockSettings.create();
        this.BLOCK_ITEM_SETTINGS = new Item.Settings();
    }

    public Item.Settings getBlockItemSettings() {
        return BLOCK_ITEM_SETTINGS;
    }

    public CustomBlock.CustomBlockSettings getBlockSettings() {
        return BLOCK_SETTINGS;
    }

    public VoxelShape createVoxelShape(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return CustomBlock.createCuboidShape(minX, minY, minZ, maxX, maxY, maxZ);
    }

    public void setVoxelShape(VoxelShape... voxelShapes) {
        this.BLOCK_SETTINGS.voxelShape(VoxelShapes.union(voxelShapes[0], Arrays.stream(voxelShapes).skip(1).toArray(VoxelShape[]::new)));
    }
}
