package kiis.ratingBE.enums;

public enum Status {

    OK(200),
    BAD_REQUEST(400), UNAUTHORIZED(401), PAYMENT_REQUIRED(402),
    FORBIDDEN(403), NOT_FOUND(404), INPUT_INVALID(499), DATABASE_MAPPING_ERROR(498),
    SERVER_ERROR(500);
    public final int code;

    Status(int code) {
        this.code = code;
    }
}
