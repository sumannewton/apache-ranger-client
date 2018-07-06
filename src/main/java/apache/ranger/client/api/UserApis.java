package apache.ranger.client.api;

import apache.ranger.client.api.feign.UserFeignClient;
import apache.ranger.client.model.User;
import apache.ranger.client.model.Users;
import apache.ranger.client.utils.RangerClientException;
import feign.Param;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author suman.bn
 */
@Slf4j
@AllArgsConstructor
public class UserApis {

    private final UserFeignClient client;

    public User createUser(final User user) throws RangerClientException {
        return client.createUser(user);
    }

    public Users searchUsers(@Param("stringSearch") final String stringSearch) {
        return client.searchUsers(stringSearch);
    }

    public User getUserByName(@Param("name") String name) throws RangerClientException {
        return client.getUserByName(name);
    }

    public void setUserVisibility(Map<String, Integer> map) {
        client.setUserVisibility(map);
    }
}