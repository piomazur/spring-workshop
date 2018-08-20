package epam.workshop.repository;

import epam.workshop.model.Creature;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CreatureRepository extends MongoRepository<Creature, String> {

    Creature findByName(String name);

    List<Creature> findByAgeBetween(Integer startAge, Integer endAge);
}
