package za.co.digitalplatoon.communicationservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + " from Spring Boot";
    }

}
