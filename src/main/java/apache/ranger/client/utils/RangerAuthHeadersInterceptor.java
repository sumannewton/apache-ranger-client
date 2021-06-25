package apache.ranger.client.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.nio.charset.Charset;

public class RangerAuthHeadersInterceptor implements RequestInterceptor {

    private String username;
    private String password;

    public RangerAuthHeadersInterceptor(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Accept", "application/json");
        template.header("Content-Type", "application/json");
        template.header("Authorization", getAuthorization());
    }

    private String getAuthorization() {
        byte[] auth = (username + ":" + password).getBytes(Charset.forName("utf-8"));
        char[] encode = Base64.encode(auth);
        StringBuilder builder = new StringBuilder("Basic ");
        builder.append(encode);
        return builder.toString();
    }

}
