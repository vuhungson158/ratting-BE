package kiis.ratingBE.enums.subjectClassification;

public enum Big {
    BASIC_GENERAL(24, "基礎総合科目"),
    SPECIALIZED_EDUCATION(58, "専門教育科目");

    public final int creditNeeded;
    public final String label;

    Big(int creditNeeded, String label) {
        this.creditNeeded = creditNeeded;
        this.label = label;
    }
}
