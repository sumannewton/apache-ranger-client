package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

/**
 * @author Shlpeng
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoleMember {
    private String name;
    private boolean isAdmin;

    @Override
    public String toString() {
        return "RoleUser{" +
                "name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
