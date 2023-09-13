package kiis.ratingBE.helper;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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

    /**
     * @param field must be Entity's OneToMany or ManyToOne field
     * @return DynamicEntityGraph
     */
    @Contract("_ -> new")
    public static @NotNull EntityGraph join(String field) {
        return join(new String[]{field});
    }

    /**
     * @param fields must be Entity's OneToMany or ManyToOne fields
     * @return DynamicEntityGraph
     */
    @Contract("_ -> new")
    public static @NotNull EntityGraph join(String... fields) {
        return DynamicEntityGraph.loading(List.of(fields));
    }
}
