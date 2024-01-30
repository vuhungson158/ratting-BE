package kiis.ratingBE.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Department {
    BASIC("基礎"), MANAGEMENT("経営"), NETWORK("ネットワーク");

    public final String label;

    Department(String label) {
        this.label = label;
    }

    public static List<Department> getValues() {
        return Arrays.stream(Department.values())
                .filter(value -> value != BASIC)
                .collect(Collectors.toList());
    }

    public static Map<Department, Integer> frame() {
        final Map<Department, Integer> map = new HashMap<>();
        getValues().forEach(department -> {
            map.put(department, 0);
        });
        return map;
    }
}
