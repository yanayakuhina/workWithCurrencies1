package nsu;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

public interface CurrencyReciver {

    abstract Valute getCurrencyByDateAndCode(String date, String currencyID) throws ParseException, ParserConfigurationException, IOException, SAXException;

}
