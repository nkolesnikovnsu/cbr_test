package com.example.cbr.controller;

import com.example.cbr.domain.Currency;
import com.example.cbr.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/day/{day}/charcode/{charcode}")
    public ResponseEntity<List<Currency>> getCurrByDate(@PathVariable Integer day, @PathVariable String charcode){
        return ResponseEntity.status(OK).body(currencyService.getCurrByDate(day, charcode));
    }

    @GetMapping("/valute")
    public ResponseEntity<List<Currency>> getValute(){
        return ResponseEntity.status(OK).body(currencyService.getValute());
    }

    @GetMapping("/charcode/{charcode}/first_date/{first_date}/second_date/{second_date}")
    public ResponseEntity<List<Currency>> getPersentValute(@PathVariable String charcode, @PathVariable Date first_date,@PathVariable Date second_date){
        return ResponseEntity.status(OK).body(currencyService.getPersentValute(charcode, first_date, second_date));
    }

}
