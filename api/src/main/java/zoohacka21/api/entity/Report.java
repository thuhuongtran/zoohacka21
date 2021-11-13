package zoohacka21.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("report")
@Accessors(chain = true)
public class Report {
    @Id
    private String id;
    @JsonProperty("created_date")
    private Date createdDate;
    @JsonProperty("report_location")
    private String reportLocation;
    @JsonProperty("animal_name")
    private String animalName;
    private String description;
    private String evidence;
    @JsonProperty("reporter_phone")
    private String reporterPhone;
}
