package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;
import lombok.*;

import java.util.List;

/**
 * @author suman.bn
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyItemCondition {
    private String type;
    private List<String> values = Lists.newArrayList();

    @Override
    public String toString() {
        return "PolicyItemCondition{" +
                "type='" + type + '\'' +
                ", values=" + values +
                '}';
    }
}
