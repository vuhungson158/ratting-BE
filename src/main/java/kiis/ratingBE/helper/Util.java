package kiis.ratingBE.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.Nullable;

public class Util {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> @Nullable T mapping(Object object, Class<T> type) {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(mapper.writeValueAsString(object), type);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
