package thebendy.bdsmapi.factory;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ItemGroupFactory {
    protected final ArrayList<Item> ITEMS;
    protected Supplier<ItemStack> iconSupplier;
    protected boolean scrollbar;

    public ItemGroupFactory() {
        this.ITEMS = new ArrayList<>();
        this.iconSupplier = () -> ItemStack.EMPTY;
        this.scrollbar = true;
    }

    public void setIcon(Identifier identifier) {
        this.iconSupplier = () -> Registries.ITEM.get(identifier).getDefaultStack();
    }

    public void noScrollBar() {
        this.scrollbar = false;
    }

    public void setIcon(Supplier<ItemStack> iconSupplier) {
        this.iconSupplier = iconSupplier;
    }

    public void addItem(Item item) {
        if (item != null) {
            ITEMS.add(item);
        }
    }

    public void addItem(Identifier identifier) {
        this.addItem(Registries.ITEM.get(identifier));
    }
}
