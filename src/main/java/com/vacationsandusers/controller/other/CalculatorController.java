package com.vacationsandusers.controller.other;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @GetMapping()
    public String calculate(@RequestParam(name = "a") Double a,
                            @RequestParam(name = "b") Double b,
                            @RequestParam(name = "operation") String operation) {
        switch (operation) {
            case "add":
                return (a + b) + "";
            case "subtract":
                return (a - b) + "";
            case "multiply":
                return (a * b) +"";
            case "divide":
                return (a / b) + "";
            default: return "The calculator can not do it";
        }
    }
}
