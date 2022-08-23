package com.example.cbr.service;

import com.example.cbr.domain.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TakeCurrencyService {
    private final Logger logger = LoggerFactory.getLogger(TakeCurrencyService.class);

    public List<Currency>  parserCurrency (Date date){
        List<Currency> currencies = new ArrayList<>();
        try {
            // fake end point that returns XML response
            String URL1 = "https://cbr.ru/scripts/XML_daily.asp?date_req=";
            String URL2= date.toString();
            String URL = URL1 + URL2;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(URL);

            // normalize XML response
            doc.getDocumentElement().normalize();

            NodeList nodelist = doc.getElementsByTagName("Valute");

           // List<Currency> currencies = new ArrayList<>();

            for( int i = 0; i<nodelist.getLength();i++){
                Node node = nodelist.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element elem = (Element) node;
                    Currency currency = new Currency(
                            Long.parseLong(elem.getElementsByTagName("id").item(0).getTextContent()),
                            elem.getElementsByTagName("numcode").item(0).getTextContent(),
                            elem.getElementsByTagName("charcode").item(0).getTextContent(),
                            Integer.parseInt(elem.getElementsByTagName("nominal").item(0).getTextContent()),
                            elem.getElementsByTagName("name").item(0).getTextContent(),
                            Double.parseDouble(elem.getElementsByTagName("value").item(0).getTextContent())
                    );
                    currency.setDate(date);
                    currencies.add(currency);
                }
            }
        } catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return currencies;
    }
}
