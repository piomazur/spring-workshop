package epam.workshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "creatures")
public class Creature {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String food;
}
