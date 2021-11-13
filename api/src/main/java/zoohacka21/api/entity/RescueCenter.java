package zoohacka21.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String location;
    private String name;
    private String phone;
}
