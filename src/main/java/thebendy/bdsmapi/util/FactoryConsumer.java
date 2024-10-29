package thebendy.bdsmapi.util;

import java.util.function.Consumer;

@FunctionalInterface
public interface FactoryConsumer<F> extends Consumer<F> {
    default F configure(F factory) {
        this.accept(factory);
        return factory;
    }
}
