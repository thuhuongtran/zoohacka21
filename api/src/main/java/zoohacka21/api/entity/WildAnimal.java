package zoohacka21.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("wild_animal")
@Accessors(chain = true)
public class WildAnimal {
    @Id
    private String id;
    private String name;
    private String description;
    @JsonProperty("rescue_center_info")
    private String rescueCenterName;
    @JsonProperty("alert_level")
    private String alertLevel;
    @JsonProperty("img_link")
    private String imageLink;
}
