package kiis.ratingBE.enums.subjectClassification;

import kiis.ratingBE.enums.Department;

import static kiis.ratingBE.enums.Department.BASIC;
import static kiis.ratingBE.enums.Department.MANAGEMENT;

public enum Small {
    HUMANITIES(Middle.GENERAL_EDUCATION, BASIC, "人文"),
    SOCIAL(Middle.GENERAL_EDUCATION, BASIC, "社会"),
    NATURAL(Middle.GENERAL_EDUCATION, BASIC, "自然"),
    SPORTS_HEALTH(Middle.GENERAL_EDUCATION, BASIC, "健康"),

    ENGLISH(Middle.LANGUAGE, BASIC, "英語"),
    CHINESE(Middle.LANGUAGE, BASIC, "中国語"),
    KOREAN(Middle.LANGUAGE, BASIC, "韓国語"),
    JAPANESE(Middle.LANGUAGE, BASIC, "日本語"),

    PRACTICE_SKILLS(Middle.CAREER_DEVELOPMENT, BASIC, "実践"),
    CAREER_DEVELOPMENT(Middle.CAREER_DEVELOPMENT, BASIC, "開発"),

    BASIC_SPECIAL_TRAINING(Middle.BASIC_SPECIAL_TRAINING, BASIC, "基礎"),

    BASIC_INFORMATION(Middle.SPECIALIZED_BASIS, BASIC, "情報"),
    BUSINESS_ACCOUNTING(Middle.SPECIALIZED_BASIS, BASIC, "経営・会計"),

    UPGRADE_INFORMATION(Middle.SPECIALIZED_UPGRADE, BASIC, "情報"),
    UPGRADE_BUSINESS_ACCOUNTING(Middle.SPECIALIZED_UPGRADE, MANAGEMENT, "経営・会計"),

    NETWORK(Middle.SPECIALIZED_PRACTICAL, Department.NETWORK, "ネットワーク"),
    DATA_SCIENCE(Middle.SPECIALIZED_PRACTICAL, Department.NETWORK, "データサイエンス"),
    ACCOUNTING(Middle.SPECIALIZED_PRACTICAL, MANAGEMENT, "会計"),
    BUSINESS(Middle.SPECIALIZED_PRACTICAL, MANAGEMENT, "経営"),
    INTERNATIONAL_BUSINESS(Middle.SPECIALIZED_PRACTICAL, MANAGEMENT, "国際ビジネス"),

    SEMINAR(Middle.SEMINAR, BASIC, "ゼミ"),

    SPECIALIZED_SPECIAL_TRAINING(Middle.SPECIALIZED_SPECIAL_TRAINING, BASIC, "専門");

    public final Middle middle;
    public final Department department;
    public final String label;

    Small(Middle middle, Department department, String label) {
        this.middle = middle;
        this.department = department;
        this.label = label;
    }
}
