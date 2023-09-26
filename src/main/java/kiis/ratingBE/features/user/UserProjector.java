package kiis.ratingBE.features.user;

import kiis.ratingBE.common.BaseProjector;
import kiis.ratingBE.enums.Gender;
import kiis.ratingBE.enums.UserRole;

/**
 * @author vuhungson
 * @see BaseProjector
 */
@SuppressWarnings("unused")
public interface UserProjector extends BaseProjector {

    /**
     * @see UserEntity#email
     */
    String getEmail();

    /**
     * @see UserEntity#password
     */
    String getPassword();

    /**
     * @see UserEntity#displayName
     */
    String getDisplayName();

    /**
     * @see UserEntity#gender
     */
    Gender getGender();

    /**
     * @see UserEntity#role
     */
    UserRole getRole();

}