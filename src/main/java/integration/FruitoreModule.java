package integration;

import com.fasterxml.jackson.databind.module.SimpleModule;
import domain.model.Fruitore;

public class FruitoreModule extends SimpleModule {
    public FruitoreModule() {
        super("CustomFruitoreModule");
        addSerializer(Fruitore .class, new FruitoreSerializer());
    }
}
