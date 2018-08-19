package epam.workshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class FriendlyHandShake {

    private static final String KNOCK_KNOCK_FRIEND = "/helloFriend";

    @Autowired
    private RestTemplate client;

    @Value("${friend.url}")
    private String friendUrl;

    @GetMapping("/handshake")
    public ResponseEntity<String> handshake() {
        log.info("I am saying hello to friend");
        String response = client.exchange(friendUrl + KNOCK_KNOCK_FRIEND, HttpMethod.GET, null, String.class).getBody();
        return ResponseEntity.ok(response);
    }
}
