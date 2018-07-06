package apache.ranger.client.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import feign.Logger;
import lombok.*;

/**
 * @author suman.bn
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class RangerClientConfig {

    private int connectTimeoutMillis = 5 * 1000;
    private int readTimeoutMillis = 30 * 1000;
    private Logger.Level logLevel = Logger.Level.BASIC;

    private String url = "http://localhost:6080";

    private RangerAuthConfig authConfig = new RangerAuthConfig();

    @Override
    public String toString() {
        return "RangerClientConfig{" +
                "connectTimeoutMillis=" + connectTimeoutMillis +
                ", readTimeoutMillis=" + readTimeoutMillis +
                ", logLevel=" + logLevel +
                ", url='" + url + '\'' +
                ", authConfig=" + authConfig +
                '}';
    }

}
