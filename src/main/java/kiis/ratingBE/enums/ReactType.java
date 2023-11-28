package kiis.ratingBE.enums;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public enum ReactType {
    LIKE, DISLIKE, LAUGH, CRY, HEART;

    public static @NotNull Map<ReactType, Integer> defaultMap() {
        final Map<ReactType, Integer> result = new HashMap<>();
        for (final ReactType reactType : ReactType.values()) {
            result.put(reactType, 0);
        }
        return result;
    }
}
