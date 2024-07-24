package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Map;

/**
 * @author Shlpeng
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
    private int id;
    private boolean isEnabled;
    private String createdBy;
    private String updatedBy;
    private String name;
    private String description;
    private Map<String, Object> options;
    private List<RoleItem> users;
    private List<RoleItem> groups;
    private List<RoleItem> roles;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", isEnabled=" + isEnabled +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", options=" + options +
                ", users=" + users +
                ", groups=" + groups +
                ", roles=" + roles +
                '}';
    }
}
