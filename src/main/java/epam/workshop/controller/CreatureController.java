package epam.workshop.controller;

import epam.workshop.model.Creature;
import epam.workshop.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/creature")
public class CreatureController {

    @Autowired
    private CreatureRepository repository;

    @PutMapping(value = "/add")
    public ResponseEntity<Creature> addCreature(@RequestBody Creature creature) {
        return ResponseEntity.ok(repository.save(creature));
    }

    @PutMapping(value = "/addAll")
    public void addCreatures(@RequestBody List<Creature> creatures) {
        repository.saveAll(creatures);
    }

    @GetMapping("/byName")
    public ResponseEntity<Creature> getCreatureByName(@RequestParam String name) {
        return ResponseEntity.ok(repository.findByName(name));
    }

    @GetMapping("/byAgeBetween")
    public ResponseEntity<List<Creature>> getCreatureByAgeBetween(@RequestParam Integer startAge,
                                                                   @RequestParam Integer endAge) {
        return ResponseEntity.ok(repository.findByAgeBetween(startAge, endAge));
    }
}
