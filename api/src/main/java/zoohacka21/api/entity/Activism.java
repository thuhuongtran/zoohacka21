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
@Document("activism")
@Accessors(chain = true)
public class Activism {
    @Id
    private String id;
    private String title;
    @JsonProperty("published_date")
    private Date publishedDate;
    private String description;
    @JsonProperty("org_name")
    private String organizationName;
    @JsonProperty("created_date")
    private Date createdDate;
    @JsonProperty("youtube_link")
    private String youtubeLink;
}
