package kiis.ratingBE.enums.subjectClassification;

import kiis.edu.rating.enums.Department;

import static kiis.edu.rating.enums.Department.ALL;
import static kiis.edu.rating.enums.Department.MANAGEMENT;

public enum Small {
    HUMANITIES(Middle.GENERAL_EDUCATION, ALL, "人文"),
    SOCIAL(Middle.GENERAL_EDUCATION, ALL, "社会"),
    NATURAL(Middle.GENERAL_EDUCATION, ALL, "自然"),
    SPORTS_HEALTH(Middle.GENERAL_EDUCATION, ALL, "健康"),

    ENGLISH(Middle.LANGUAGE, ALL, "英語"),
    CHINESE(Middle.LANGUAGE, ALL, "中国語"),
    KOREAN(Middle.LANGUAGE, ALL, "韓国語"),
    JAPANESE(Middle.LANGUAGE, ALL, "日本語"),

    PRACTICE_SKILLS(Middle.CAREER_DEVELOPMENT, ALL, "実践"),
    CAREER_DEVELOPMENT(Middle.CAREER_DEVELOPMENT, ALL, "開発"),

    BASIC_SPECIAL_TRAINING(Middle.BASIC_SPECIAL_TRAINING, ALL, "基礎"),

    BASIC_INFORMATION(Middle.SPECIALIZED_BASIS, ALL, "情報"),
    BUSINESS_ACCOUNTING(Middle.SPECIALIZED_BASIS, ALL, "経営・会計"),

    UPGRADE_INFORMATION(Middle.SPECIALIZED_UPGRADE, ALL, "情報"),
    UPGRADE_BUSINESS_ACCOUNTING(Middle.SPECIALIZED_UPGRADE, MANAGEMENT, "経営・会計"),

    NETWORK(Middle.SPECIALIZED_PRACTICAL, Department.NETWORK, "ネットワーク"),
    DATA_SCIENCE(Middle.SPECIALIZED_PRACTICAL, Department.NETWORK, "データサイエンス"),
    ACCOUNTING(Middle.SPECIALIZED_PRACTICAL, MANAGEMENT, "会計"),
    BUSINESS(Middle.SPECIALIZED_PRACTICAL, MANAGEMENT, "経営"),
    INTERNATIONAL_BUSINESS(Middle.SPECIALIZED_PRACTICAL, MANAGEMENT, "国際ビジネス"),

    SEMINAR(Middle.SEMINAR, ALL, "ゼミ"),

    SPECIALIZED_SPECIAL_TRAINING(Middle.SPECIALIZED_SPECIAL_TRAINING, ALL, "専門");

    public final Middle middle;
    public final Department department;
    public final String label;

    Small(Middle middle, Department department, String label) {
        this.middle = middle;
        this.department = department;
        this.label = label;
    }
}
