package thebendy.bdsmapi.factory;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import thebendy.bdsmapi.custom.*;

public class FactoryManager {
    public static CustomBlock registerBlock(Identifier identifier, BlockFactory blockFactory) {
        CustomBlock customBlock = new CustomBlock(blockFactory.BLOCK_SETTINGS);

        return FactoryManager.registerAbstractBlock(identifier, customBlock, blockFactory);
    }

    public static CustomBlockWithEntity<CustomBlockEntity> registerBlockWithEntity(Identifier identifier, BlockWithEntityFactory blockWithEntityFactory) {
        CustomBlockWithEntity<CustomBlockEntity> customBlockWithEntity = new CustomBlockWithEntity<>(blockWithEntityFactory.BLOCK_SETTINGS);

        return FactoryManager.registerAbstractBlockWithEntity(identifier, customBlockWithEntity, blockWithEntityFactory);
    }

    public static ItemGroup registerItemGroup(Identifier identifier, ItemGroupFactory itemGroupFactory) {
        ItemGroup.Builder itemGroupBuilder = ItemGroup.create(ItemGroup.Row.BOTTOM, 0).entries((displayContext, entries) -> {
            itemGroupFactory.ITEMS.forEach((item) -> {
                entries.add(item.getDefaultStack());
            });
        }).icon(itemGroupFactory.iconSupplier).displayName(Text.translatable("itemGroup." + identifier.getPath()));

        if (!itemGroupFactory.scrollbar) {
            itemGroupBuilder.noScrollbar();
        }

        return Registry.register(Registries.ITEM_GROUP, identifier, itemGroupBuilder.build());
    }

    public static CustomGeoBlock registerGeoBlock(Identifier identifier, GeoBlockFactory geoBlockFactory) {
        CustomGeoBlock customGeoBlock = new CustomGeoBlock(geoBlockFactory.BLOCK_SETTINGS, geoBlockFactory.animation);

        FactoryManager.registerAbstractBlockWithEntity(identifier, customGeoBlock, geoBlockFactory);

        return customGeoBlock;
    }

    private static <F extends BlockWithEntityFactory, B extends CustomBlockWithEntity<? extends CustomBlockEntity>> B registerAbstractBlockWithEntity(Identifier identifier, B customBlockWithEntity, F blockWithEntityFactory) {
        FactoryManager.registerAbstractBlock(identifier, customBlockWithEntity, blockWithEntityFactory);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, identifier, customBlockWithEntity.BLOCK_ENTITY_TYPE);

        return customBlockWithEntity;
    }

    private static <F extends BlockFactory, B extends CustomBlock> B registerAbstractBlock(Identifier identifier, B customBlock, F blockFactory) {
        BlockItem blockItem = new BlockItem(customBlock, blockFactory.BLOCK_ITEM_SETTINGS);

        Registry.register(Registries.BLOCK, identifier, customBlock);
        Registry.register(Registries.ITEM, identifier, blockItem);

        return customBlock;
    }
}
