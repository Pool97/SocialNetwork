package integration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JSONDeserializer<T> {
    private ObjectMapper objectMapper;
    private String filePath;

    public JSONDeserializer(String filePath){
        this.filePath = filePath;
        objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
                setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public List<T> deserializzaElenco(Class<T> type){
        try {
            CollectionLikeType listType = objectMapper.getTypeFactory().constructCollectionLikeType(ArrayList.class, type);
            return objectMapper.readValue(new File(filePath), listType);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}
