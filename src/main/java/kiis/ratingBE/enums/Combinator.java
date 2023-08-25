package kiis.ratingBE.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Combinator {
    private final UserRole.Feature feature;
    private final UserRole.Method method;

    public String concat() {
        return feature.name() + "__" + method.name();
    }
}

