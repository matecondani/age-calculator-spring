package com.marcos.saguier.msagecalc.service;

import org.springframework.http.ResponseEntity;

public interface ICalculatorService {

    public ResponseEntity<?> generateCalculatedAge(String date);
}
