package kiis.ratingBE.service.common;

public abstract class PageableUtil {

    /**
     * @return make page start from 1 instead 0
     */
    public static int syncPage(int page) {
        return page - 1;
    }
}
