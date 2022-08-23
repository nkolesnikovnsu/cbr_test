package com.example.cbr.service;

import com.example.cbr.domain.Currency;
import com.example.cbr.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyClient currencyClient;

    public List<Currency> findCourseInfo(Date date){
        return currencyRepository.saveAll(currencyClient.getCourses());
    }

    public List<Currency> getCurrByDate(Integer day, String charcode) {
        return currencyRepository.getCurrByDate(day, charcode);
    }

    public List<Currency> getValute() {
        return currencyRepository.getValute();
    }

    public List<Currency> getPersentValute(String charcode, Date first_date, Date second_date) {
        return currencyRepository.getPersentValute(charcode, first_date, second_date);
    }
}
