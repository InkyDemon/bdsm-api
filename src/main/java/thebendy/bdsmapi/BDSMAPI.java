package thebendy.bdsmapi;

import dev.felnull.specialmodelloader.api.event.SpecialModelLoaderEvents;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import thebendy.bdsmapi.custom.*;
import thebendy.bdsmapi.factory.*;
import thebendy.bdsmapi.util.FactoryConsumer;

public class BDSMAPI {
    public static CustomBlock createBlock(Identifier identifier, FactoryConsumer<BlockFactory> configuration) {
        return FactoryManager.registerBlock(identifier, configuration.configure(new BlockFactory()));
    }

    public static CustomBlock createBlock(Identifier identifier) {
        return FactoryManager.registerBlock(identifier, new BlockFactory());
    }

    public static CustomBlockWithEntity<CustomBlockEntity> createBlockWithEntity(Identifier identifier, FactoryConsumer<BlockWithEntityFactory> configuration) {
        return FactoryManager.registerBlockWithEntity(identifier, configuration.configure(new BlockWithEntityFactory()));
    }

    public static CustomGeoBlock createGeoBlock(Identifier identifier, FactoryConsumer<GeoBlockFactory> configuration) {
        return FactoryManager.registerGeoBlock(identifier, configuration.configure(new GeoBlockFactory()));
    }

    public static Identifier createIdentifier(String namespace, String path) {
        return new Identifier(namespace, path);
    }

    public static ItemGroup createItemGroup(Identifier identifier, FactoryConsumer<ItemGroupFactory> configuration) {
        return FactoryManager.registerItemGroup(identifier, configuration.configure(new ItemGroupFactory()));
    }


    public static ItemGroup createItemGroup(Identifier identifier) {
        return FactoryManager.registerItemGroup(identifier, new ItemGroupFactory());
    }

    public static CustomGeoBlockEntity getGeoBlockEntity(World world, BlockPos pos) {
        return (CustomGeoBlockEntity) world.getBlockEntity(pos);
    }

    public static CustomBlockEntity getBlockEntity(World world, BlockPos pos) {
        return (CustomBlockEntity) world.getBlockEntity(pos);
    }

    public static void registerGeoBlockRenderer(Identifier identifier) {
        BlockEntityRendererFactories.register((BlockEntityType<CustomGeoBlockEntity>) Registries.BLOCK_ENTITY_TYPE.get(identifier), ctx -> new GeoBlockRenderer<>(new GeoModel<>() {
            @Override
            public Identifier getModelResource(CustomGeoBlockEntity customGeoBlockEntity) {
                return identifier.withPath("geo/models/" + identifier.getPath() + ".geo.json");
            }

            @Override
            public Identifier getTextureResource(CustomGeoBlockEntity customGeoBlockEntity) {
                return identifier.withPath("geo/textures/" + identifier.getPath() + ".png");
            }

            @Override
            public Identifier getAnimationResource(CustomGeoBlockEntity customGeoBlockEntity) {
                return identifier.withPath("geo/animations/" + identifier.getPath() + ".animation.json");
            }
        }));
    }

    public static void registerObjLoader(String modId) {
        SpecialModelLoaderEvents.LOAD_SCOPE.register(location -> modId.equals(location.getNamespace()));
    }
}
