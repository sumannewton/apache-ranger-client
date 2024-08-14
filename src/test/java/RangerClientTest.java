import apache.ranger.client.RangerClient;
import apache.ranger.client.config.RangerAuthConfig;
import apache.ranger.client.config.RangerClientConfig;
import apache.ranger.client.model.Policy;
import apache.ranger.client.model.Role;
import apache.ranger.client.model.RoleMember;
import apache.ranger.client.model.Service;
import apache.ranger.client.model.User;
import com.google.common.collect.Maps;
import feign.Logger;

/**
 * @author suman.bn
 */
public class RangerClientTest {

    public static final String RANGER_URL = "http://localhost:6080";
    private static RangerClient rangerClient;

    public static void main(String[] args) throws Exception {

        /*
        Initialize client.
         */
        final RangerClientConfig rangerClientConfig = RangerClientConfig.builder()
                .connectTimeoutMillis(1000)
                .readTimeoutMillis(1000)
                .logLevel(Logger.Level.BASIC)
                .authConfig(RangerAuthConfig.builder()
                        .username("admin")
                        .password("admin")
                        .build())
                .url(RANGER_URL)
                .build();
        rangerClient = new RangerClient(rangerClientConfig);

        /*
        Start Client.
         */
        rangerClient.start();

        /*
        Create/Update/Get/Search Users
         */
        rangerClient.getUsers().createUser(User.builder().build());
        rangerClient.getUsers().getUserByName("user");
        rangerClient.getUsers().setUserVisibility(Maps.newHashMap());
        rangerClient.getUsers().searchUsers("userSearch");

        /*
        Create/Update/Get/Search Services
         */
        rangerClient.getServices().createService(Service.builder().build());
        rangerClient.getServices().getServiceByName("service");
        rangerClient.getServices().updateService("service", Service.builder().build());
        rangerClient.getServices().searchServices("serviceSearch");

        /*
        Create/Update/Get/Search Policies
         */
        rangerClient.getPolicies().createPolicy(Policy.builder().build());
        rangerClient.getPolicies().getPolicyByName("service", "policy");
        rangerClient.getPolicies().updatePolicy(1, Policy.builder().build());
        rangerClient.getPolicies().getAllPoliciesByService("service");
        rangerClient.getPolicies().searchPolicies("service", "policySearch");

        /*
        Create/Update/Get/Search Roles
         */
        Role role = rangerClient.getRoles().getRoleByName("data");
        role.getUsers().add(RoleMember.builder().name("Shlpeng").build());
        rangerClient.getRoles().addUsersAndGroups(role.getId(), role);
    }
}
