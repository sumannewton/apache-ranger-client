package apache.ranger.client.utils;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

import static java.lang.String.format;

/**
 * @author suman.bn
 */
public class RangerErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return new RangerClientException(response.status(), errorMessage(methodKey, response));
    }

    public static String errorMessage(String methodKey, Response response) {
        String message = format("status %s reading %s", response.status(), methodKey);
        try {
            if (response.body() != null) {
                String body = Util.toString(response.body().asReader());
                message += "; content:\n" + body;
            }
        } catch (IOException ignored) { // NOPMD
        }
        return message;
    }
}
