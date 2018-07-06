package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

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
public class Service {
    private int id;
    private String guid;
    private boolean isEnabled;
    private String createdBy;
    private String updatedBy;
    private long createTime;
    private long updateTime;
    private long version;
    private String type;
    private String name;
    private String description;
    private Map<String, String> configs;
    private int policyVersion;
    private long policyUpdateTime;
    private int tagVersion;
    private long tagUpdateTime;

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", guid='" + guid + '\'' +
                ", isEnabled=" + isEnabled +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", version=" + version +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", config=" + configs +
                ", policyVersion=" + policyVersion +
                ", policyUpdateTime=" + policyUpdateTime +
                ", tagVersion=" + tagVersion +
                ", tagUpdateTime=" + tagUpdateTime +
                '}';
    }
}
