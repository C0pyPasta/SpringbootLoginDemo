package springbootLogin.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisatorOmgevingEndpoint {

    @GetMapping("organisatorOmgeving")
    public String go() {
        System.out.println("Organisator omgeving aangesproken");
        return "Welkom in de Organisator omgeving";
    }
}