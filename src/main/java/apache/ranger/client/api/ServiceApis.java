package apache.ranger.client.api;

import apache.ranger.client.api.feign.ServiceFeignClient;
import apache.ranger.client.model.Service;
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
public class ServiceApis {

    private final ServiceFeignClient client;

    public Service createService(final Service service) throws RangerClientException {
        return client.createService(service);
    }

    public Service updateService(@Param("serviceName") final String serviceName,
                                 final Service service) throws RangerClientException {
        return client.updateService(serviceName, service);
    }

    public List<Service> searchServices(@Param("stringSearch") final String stringSearch) throws RangerClientException {
        return client.searchServices(stringSearch);
    }

    public Service getServiceByName(@Param("name") final String name) throws RangerClientException {
        return client.getServiceByName(name);
    }
}
