package apache.ranger.client.api.feign;

import apache.ranger.client.model.Role;
import apache.ranger.client.utils.RangerClientException;
import feign.Param;
import feign.RequestLine;

/**
 * @author Shlpeng
 */
public interface RoleFeignClient {

    /*
    Mapper to Ranger User APIs
     */
    @RequestLine("GET /service/public/v2/api/roles/name/{name}")
    Role getRoleByName(@Param("name") final String name) throws RangerClientException;


    @RequestLine("PUT /service/public/v2/api/roles/{id}")
    Role addUsersAndGroups(@Param("id") final int id, final Role role) throws RangerClientException;
}
