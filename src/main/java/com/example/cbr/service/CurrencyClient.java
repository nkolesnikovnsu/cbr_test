package com.example.cbr.service;

import com.example.cbr.domain.Currency;
import com.example.cbr.dto.CursDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CurrencyClient {
    public static final String URL = "https://cbr.ru/scripts/XML_daily.asp?date_req=23/08/2022.xml";

    final RestTemplate restTemplate = new RestTemplate();

    public List<Currency> getCourses() {
        CursDto response = restTemplate.getForObject(URL, CursDto.class);

        if (response != null) {
            response
                    .getCurrency()
                    .forEach(x -> {
                        x.setValue(Double.parseDouble(x.get_Value().replace(",", ".")));
                        System.out.println(x);
                    });

            return response.getCurrency();
        }
        return null;
    }
}
