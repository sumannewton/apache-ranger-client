package apache.ranger.client.utils;

/**
 * @author suman.bn
 */
public class RangerClientException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private Throwable cause;
    private int status;
    private String message;

    public RangerClientException(int status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * Gets the HTTP status code of the failure, such as 404.
     */
    public int getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message + " (http status: " + status + ")";
    }

    @Override
    public String toString() {
        return message + " (http status: " + status + ")";
    }
}
