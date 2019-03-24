package integration;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CustomObjectMapper extends ObjectMapper {
    private static CustomObjectMapper mapper = null;

    public CustomObjectMapper() {
        disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE).
                setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        registerModule(new FruitoreModule());
    }

    public static CustomObjectMapper getIstanza(){
        if(mapper == null){
            mapper = new CustomObjectMapper();
        }

        return mapper;
    }
}
