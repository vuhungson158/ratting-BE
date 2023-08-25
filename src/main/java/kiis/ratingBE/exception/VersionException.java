package kiis.ratingBE.exception;

public class VersionException extends RuntimeException {
    public VersionException() {
        super("Version error");
    }
}
