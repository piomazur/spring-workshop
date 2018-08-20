package epam.workshop.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Environment {

    @Id
    private String id;

    private String name;

    private Double sizeInMeter;

    private String continent;
}
