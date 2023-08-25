package kiis.ratingBE.enums.subjectClassification;

public enum Middle {
    GENERAL_EDUCATION(Big.BASIC_GENERAL, 8, "総合教養"),
    LANGUAGE(Big.BASIC_GENERAL, 4, "語学"),
    CAREER_DEVELOPMENT(Big.BASIC_GENERAL, 2, "実践力養成・キャリア開発"),
    BASIC_SPECIAL_TRAINING(Big.BASIC_GENERAL, 0, "特別"),

    SPECIALIZED_BASIS(Big.SPECIALIZED_EDUCATION, 12, "専門基礎"),
    SPECIALIZED_UPGRADE(Big.SPECIALIZED_EDUCATION, 8, "専門発展"),
    SPECIALIZED_PRACTICAL(Big.SPECIALIZED_EDUCATION, 24, "専門応用"),
    SEMINAR(Big.SPECIALIZED_EDUCATION, 0, "演習"),
    SPECIALIZED_SPECIAL_TRAINING(Big.SPECIALIZED_EDUCATION, 0, "特別");

    public final Big big;
    public final int creditNeeded;
    public final String label;

    Middle(Big big, int creditNeeded, String label) {
        this.big = big;
        this.creditNeeded = creditNeeded;
        this.label = label;
    }
}
