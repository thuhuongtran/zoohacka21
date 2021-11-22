package zoohacka21.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("rescue_center")
@Accessors(chain = true)
public class RescueCenter {
    @Id
    private String id;
    private String name;
    private String description;
    @JsonProperty("org_url")
    private String organizationUrl;
    private String location;
    private String phone;
    @JsonProperty("image_link")
    private String imageLink;
}
