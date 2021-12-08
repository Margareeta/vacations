package com.vacationsandusers.controller.other;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class GreetingController {

    @GetMapping("/greeting/{name}")
    public String englishGreeting(@PathVariable(name = "name") String word) {
        return "Hello " + word;
    }

    @GetMapping("/greeting2")
    public String russianGreeting1(@RequestParam(name = "name") String name,
                                   @RequestParam(name = "surname") String surname) {
        return "Привет! " + name + " " + surname;
    }

    @GetMapping("/greeting3")
    public String spanishGreeting2(@RequestParam(name = "name", required = false) String name,
                                   @RequestParam(name = "surname", required = false) String surname) {
        return "Hola!" + name + " " + surname;

    }
}
