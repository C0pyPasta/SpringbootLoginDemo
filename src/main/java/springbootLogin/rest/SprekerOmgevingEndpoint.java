package springbootLogin.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SprekerOmgevingEndpoint {

    @GetMapping("sprekerOmgeving")
    public String go() {
        System.out.println("Spreker omgeving Aangesproken");
        return "Welkom in de Spreker omgeving";
    }
}