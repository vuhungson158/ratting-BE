package kiis.ratingBE.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Util {
    final static ObjectMapper mapper = new ObjectMapper();
    final static Logger logger = LoggerFactory.getLogger(Util.class);

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> @Nullable T mapping(Object object, Class<T> type) {
        try {
            return mapper.readValue(mapper.writeValueAsString(object), type);
        } catch (final JsonProcessingException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
