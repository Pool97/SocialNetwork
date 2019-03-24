package integration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import domain.model.Fruitore;

import java.io.IOException;

public class FruitoreSerializer extends JsonSerializer<Fruitore> {

    @Override
    public void serialize(Fruitore value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

    }
}
