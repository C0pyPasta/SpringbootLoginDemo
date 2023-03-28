package springbootLogin.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdministratorOmgevingEndpoint {

    @GetMapping("AdministratorOmgeving")
    public String go() {
        System.out.println("Administrator omgeving aangesproken");
        return "Welkom in de Administrator omgeving";
    }
}