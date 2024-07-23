package apache.ranger.client;

import apache.ranger.client.api.PolicyApis;
import apache.ranger.client.api.RoleApis;
import apache.ranger.client.api.ServiceApis;
import apache.ranger.client.api.UserApis;
import apache.ranger.client.api.feign.PolicyFeignClient;
import apache.ranger.client.api.feign.RoleFeignClient;
import apache.ranger.client.api.feign.ServiceFeignClient;
import apache.ranger.client.api.feign.UserFeignClient;
import apache.ranger.client.config.RangerClientConfig;
import apache.ranger.client.utils.ClientException;
import apache.ranger.client.utils.RangerAuthHeadersInterceptor;
import apache.ranger.client.utils.RangerErrorDecoder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author suman.bn
 */
@Slf4j
public class RangerClient implements Client {

    @Getter
    private UserApis users;

    @Getter
    private ServiceApis services;

    @Getter
    private PolicyApis policies;

    @Getter
    private RoleApis roles;

    private RangerClientConfig clientConfig;

    public RangerClient(RangerClientConfig clientConfig) {
        this.clientConfig = clientConfig;
    }

    private final static ObjectMapper mapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private final static JacksonEncoder encoder = new JacksonEncoder(mapper);
    private final static JacksonDecoder decoder = new JacksonDecoder(mapper);

    private AtomicBoolean started = new AtomicBoolean(false);

    @Override
    public void start() throws Exception {
        if (started.get()) {
            log.info("apache-ranger client is already started...");
            return;
        }

        initialize();

        this.started.set(true);
        log.info("Initialized apache-ranger client...");
    }

    private void initialize() {
        users = new UserApis(feignBuilder().target(UserFeignClient.class, clientConfig.getUrl()));
        services = new ServiceApis(feignBuilder().target(ServiceFeignClient.class, clientConfig.getUrl()));
        policies = new PolicyApis(feignBuilder().target(PolicyFeignClient.class, clientConfig.getUrl()));
        roles = new RoleApis(feignBuilder().target(RoleFeignClient.class, clientConfig.getUrl()));
    }

    @Override
    public void stop() throws Exception {
        isStarted();
        this.started.set(false);
        log.info("Stopped apache-ranger client...");
    }

    private Feign.Builder feignBuilder() {
        return Feign.builder()
                .logger(new Logger.JavaLogger())
                .logLevel(clientConfig.getLogLevel())
                .options(new Request.Options(clientConfig.getConnectTimeoutMillis(),
                        clientConfig.getReadTimeoutMillis()))
                .encoder(encoder)
                .decoder(decoder)
                .client(new OkHttpClient())
                .errorDecoder(new RangerErrorDecoder())
                .requestInterceptor(new RangerAuthHeadersInterceptor(clientConfig.getAuthConfig().getUsername(), clientConfig.getAuthConfig().getPassword()));
    }

    /*
     * Is client Started?
     */
    private void isStarted() {
        if (!this.started.get()) {
            log.error("apache-ranger client is not yet started.");
            throw new ClientException("apache-ranger client is not yet started.");
        }
    }
}
