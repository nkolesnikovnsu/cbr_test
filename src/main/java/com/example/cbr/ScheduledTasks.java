package com.example.cbr;

import com.example.cbr.domain.Currency;
import com.example.cbr.service.CurrencyService;
import com.example.cbr.service.TakeCurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
    public class ScheduledTasks {
    private TakeCurrencyService takeCurrencyService;

    public ScheduledTasks(TakeCurrencyService takeCurrencyService) {
        this.takeCurrencyService = takeCurrencyService;
    }
        @Scheduled(cron = "@daily")
        public void CheckCurrency() throws IOException {
            List<Currency> currencies;
            Calendar start = Calendar.getInstance();
            start.add(Calendar.DATE, -30);
            Calendar end = Calendar.getInstance();
            for (Calendar date = start; date.before(end); date.add(Calendar.DATE, 1)) {
                currencies = takeCurrencyService.parserCurrency(date.getTime());
                System.out.println(currencies);
                System.out.println(date.getTime());
            }
        }
    }
