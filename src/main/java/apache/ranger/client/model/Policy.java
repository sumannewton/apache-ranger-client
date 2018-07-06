package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @author suman.bn
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Policy {
    Map<String, PolicyResource> resources;
    List<PolicyItem> policyItems = Lists.newArrayList();
    List<PolicyItem> denyPolicyItems = Lists.newArrayList();
    List<PolicyItem> allowExceptions = Lists.newArrayList();
    List<PolicyItem> denyExceptions = Lists.newArrayList();
    List<Object> dataMaskPolicyItems = Lists.newArrayList();
    List<Object> rowFilterPolicyItems = Lists.newArrayList();
    private int id;
    private String guid;
    private boolean isEnabled;
    private int version;
    private String service;
    private String name;
    private int policyType;
    private String description;
    private boolean isAuditEnabled;

    @Override
    public String toString() {
        return "Policy{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", isEnabled=" + isEnabled +
                ", version=" + version +
                ", service='" + service + '\'' +
                ", name='" + name + '\'' +
                ", policyType=" + policyType +
                ", description='" + description + '\'' +
                ", isAuditEnabled=" + isAuditEnabled +
                ", ResourcesObject=" + resources +
                ", policyItems=" + policyItems +
                ", denyPolicyItems=" + denyPolicyItems +
                ", allowExceptions=" + allowExceptions +
                ", denyExceptions=" + denyExceptions +
                ", dataMaskPolicyItems=" + dataMaskPolicyItems +
                ", rowFilterPolicyItems=" + rowFilterPolicyItems +
                '}';
    }
}
