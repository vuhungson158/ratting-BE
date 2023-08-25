package kiis.ratingBE.enums;

public enum Year {
    ONE(1), TWO(2), THREE(3, 4);

    public final int[] year;

    Year(int... year) {
        this.year = year;
    }
}
