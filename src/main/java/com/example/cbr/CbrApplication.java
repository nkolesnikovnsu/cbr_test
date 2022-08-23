package com.example.cbr;

import com.example.cbr.domain.Currency;
import com.example.cbr.repository.CurrencyRepository;
import com.example.cbr.service.CurrencyClient;
import com.example.cbr.service.TakeCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class CbrApplication implements CommandLineRunner {
    private TakeCurrencyService takeCurrencyService;

    public CbrApplication(TakeCurrencyService takeCurrencyService) {
        this.takeCurrencyService = takeCurrencyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CbrApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
