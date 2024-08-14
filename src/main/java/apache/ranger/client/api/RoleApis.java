package apache.ranger.client.api;

import apache.ranger.client.api.feign.RoleFeignClient;
import apache.ranger.client.model.Role;
import apache.ranger.client.utils.RangerClientException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Shlpeng
 */
@Slf4j
@AllArgsConstructor
public class RoleApis {

    private final RoleFeignClient client;

    public Role getRoleByName(final String name) throws RangerClientException {
        return client.getRoleByName(name);
    }

    public Role addUsersAndGroups(final int id, final Role role) throws RangerClientException {
        return client.addUsersAndGroups(id, role);
    }
}
