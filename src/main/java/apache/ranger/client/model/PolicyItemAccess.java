package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author suman.bn
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyItemAccess {
    private String type;
    private Boolean isAllowed;

    @Override
    public String toString() {
        return "PolicyItemAccess{" +
                "type='" + type + '\'' +
                ", isAllowed=" + isAllowed +
                '}';
    }
}