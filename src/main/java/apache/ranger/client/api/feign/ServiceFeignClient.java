package apache.ranger.client.api.feign;

import apache.ranger.client.model.Service;
import apache.ranger.client.utils.RangerClientException;
import feign.Param;
import feign.RequestLine;

import java.util.List;

/**
 * @author suman.bn
 */
public interface ServiceFeignClient {

    /*
    Mapper to Ranger Service APIs
     */
    @RequestLine("POST /service/public/v2/api/service")
    Service createService(final Service service) throws RangerClientException;

    @RequestLine("PUT /service/public/v2/api/service/name/{serviceName}")
    Service updateService(@Param("serviceName") final String serviceName, final Service service) throws RangerClientException;

    @RequestLine("GET /service/public/v2/api/service?serviceNamePartial={stringSearch}")
    List<Service> searchServices(@Param("stringSearch") final String stringSearch) throws RangerClientException;

    @RequestLine("GET /service/public/v2/api/service/name/{name}")
    Service getServiceByName(@Param("name") final String name) throws RangerClientException;
}
