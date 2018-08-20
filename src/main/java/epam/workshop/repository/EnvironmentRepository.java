package epam.workshop.repository;

import epam.workshop.model.Environment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "environments", path = "environment")
public interface EnvironmentRepository extends MongoRepository<Environment, String> {
}
