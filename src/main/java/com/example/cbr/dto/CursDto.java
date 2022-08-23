package com.example.cbr.dto;

import com.example.cbr.domain.Currency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@XmlRootElement(name = "CurrencyCurs")
@XmlAccessorType(XmlAccessType.FIELD)
public class CursDto implements Serializable {

    @XmlElement(name = "Currency")
    private List<Currency> currency;
    @XmlElement(name = "Date")
    private LocalDate date;

    public List<Currency> getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "CursDto{" +
                "currency=" + currency +
                ", date=" + date +
                '}';
    }
}
