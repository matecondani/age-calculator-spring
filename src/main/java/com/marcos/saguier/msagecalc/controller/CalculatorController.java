package com.marcos.saguier.msagecalc.controller;

import com.marcos.saguier.msagecalc.service.ICalculatorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculator", produces = MediaType.APPLICATION_JSON_VALUE)
public class CalculatorController {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private final ICalculatorService calculatorService;

    public CalculatorController(ICalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/age")
    public ResponseEntity<?> calculateAge(@RequestParam @DateTimeFormat(pattern = DATE_PATTERN) String birthDate) {
        return calculatorService.generateCalculatedAge(birthDate);
    }
}
