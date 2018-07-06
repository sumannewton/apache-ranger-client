package apache.ranger.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class Users {
    private int startIndex;
    private int pageSize;
    private int totalCount;
    private int resultSize;
    private String sortType;
    private String sortBy;
    private int queryTimeMS;
    private List<User> vXUsers;

    @Override
    public String toString() {
        return "Users{" +
                "startIndex=" + startIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", resultSize=" + resultSize +
                ", sortType='" + sortType + '\'' +
                ", sortBy='" + sortBy + '\'' +
                ", queryTimeMS=" + queryTimeMS +
                ", vXUsers=" + vXUsers +
                '}';
    }
}
