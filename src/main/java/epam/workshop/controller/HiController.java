package epam.workshop.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class HiController {

    @Autowired
    MeterRegistry registry;

    private Counter counter;

    @PostConstruct
    public void setUp() {
        counter = Counter
                .builder("say.hello.hit.count")
                .description("indicates instance count of the object")
                .tags("dev", "performance")
                .register(registry);
    }

    @GetMapping("/sayHello")
    public ResponseEntity<String> sayHello() {
        counter.increment();
        return ResponseEntity.ok("Hello");
    }
}
