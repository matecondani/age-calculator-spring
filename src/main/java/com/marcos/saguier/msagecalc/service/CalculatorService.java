package com.marcos.saguier.msagecalc.service;

import com.marcos.saguier.msagecalc.entity.AgeDTO;
import com.marcos.saguier.msagecalc.entity.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@Service
public class CalculatorService implements ICalculatorService {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorService.class);
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public ResponseEntity<?> generateCalculatedAge(String date) {
        AgeDTO ageDTO = new AgeDTO();
        try {
            LocalDate birthDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_PATTERN));
            Period period = birthDate.until(LocalDate.now());
            ageDTO.setAge(period.getYears());
        } catch (DateTimeException exception) {
            LOG.error("Age could not be calculate for birthdate: {}, Exception: {}", date, exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST.value(),
                    "calculator-service.generate-calculated-age.bad-request"));
        }
        return new ResponseEntity<>(ageDTO, HttpStatus.OK);
    }
}