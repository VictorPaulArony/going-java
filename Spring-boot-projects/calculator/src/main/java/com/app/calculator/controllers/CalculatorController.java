package com.app.calculator.controller;

import com.app.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculatorController {
    private final CalculatorService calculatorService;


    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    //defining the calculation for the arithmatics

    @GetMapping("/add")
    public double add(@RequestParam double a, @RequestParam double b) {
        return calculatorService.add(a,b);
    }

    @RequestMapping("/subtract")
    public double sub(@RequestParam double a, @RequestParam double b){
        return calculatorService.sub(a,b);
    }


    @GetMapping("/multiply")
    public double multiply(@RequestParam double a, @RequestParam double b) {
        return calculatorService.mult(a, b);
    }

    @GetMapping("/divide")
    public double divide(@RequestParam double a, @RequestParam double b) {
        return calculatorService.div(a, b);
    }

    @GetMapping("/modulus")
    public double mod(@RequestParam double a, @RequestParam double b) {
        return calculatorService.mod(a, b);
    }

}