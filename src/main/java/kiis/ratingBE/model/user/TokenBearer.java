package kiis.ratingBE.model.user;

import static kiis.ratingBE.helper.Constant.BEARER;


/**
 * This data type exists because only one purpose.<br>
 * {@link kiis.ratingBE.security.ResponseWrapper} <strong>can't</strong> wrap {@link String}<br>
 * Exception Message: cannot be cast to class {@link String}
 */
public record TokenBearer(String token) {
    public TokenBearer(String token) {
        this.token = BEARER + token;
    }
}
