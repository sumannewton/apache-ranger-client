package apache.ranger.client.api;

import apache.ranger.client.api.feign.PolicyFeignClient;
import apache.ranger.client.model.Policy;
import apache.ranger.client.utils.RangerClientException;
import feign.Param;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author suman.bn
 */
@Slf4j
@AllArgsConstructor
public class PolicyApis {

    private final PolicyFeignClient client;

    public Policy createPolicy(final Policy policy) throws RangerClientException {
        return client.createPolicy(policy);
    }

    public Policy getPolicyByName(@Param("serviceName") final String serviceName,
                                  @Param("policyName") final String policyName) throws RangerClientException {
        return client.getPolicyByName(serviceName, policyName);
    }

    public Policy updatePolicy(@Param("policyId") final int policyId, final Policy policy) throws RangerClientException {
        return client.updatePolicy(policyId, policy);
    }

    public List<Policy> searchPolicies(@Param("serviceName") final String serviceName,
                                       @Param("stringSearch") final String stringSearch) throws RangerClientException {
        return client.searchPolicies(serviceName, stringSearch);
    }

    public List<Policy> getAllPoliciesByService(@Param("serviceName") final String serviceName) throws RangerClientException {
        return client.getAllPoliciesByService(serviceName);
    }
}
