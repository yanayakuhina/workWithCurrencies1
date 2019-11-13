package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        String date = Options.getDate1(args);
        String currencuID = Options.getCurrencyID1(args);

        CurrencyReciver x = new BDCurrencyReciver();
        CurrencyReciver c = new CBCurrencyReciver();
        if (Options.dateInsert(args) != null){
            Dom.parseForDatabase(Options.dateInsert(args));
            System.out.println("База данных дополнена данными за "+ Options.dateInsert(args));
        }
        else {
            Valute optionalValute = x.getCurrencyByDateAndCode(date, currencuID);
            if (optionalValute != null) {
                Valute v = optionalValute;
                System.out.println(v.toString());
                ValuteWriter.write(args, v);
            } else {
                Valute v = c.getCurrencyByDateAndCode(date, currencuID);
                System.out.println(v.getName());
                ValuteWriter.write(args, v);
            }
        }

    }
}
