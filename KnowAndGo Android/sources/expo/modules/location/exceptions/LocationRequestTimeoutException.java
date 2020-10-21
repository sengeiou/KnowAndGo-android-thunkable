package expo.modules.location.exceptions;

import org.unimodules.core.errors.CodedException;
import org.unimodules.core.interfaces.CodedThrowable;

public class LocationRequestTimeoutException extends CodedException implements CodedThrowable {
    public String getCode() {
        return "E_LOCATION_TIMEOUT";
    }

    public LocationRequestTimeoutException() {
        super("Location request timed out.");
    }
}
