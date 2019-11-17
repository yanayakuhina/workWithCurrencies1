package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        String date = Options.getDate1(args);
        String currencuID = Options.getCurrencyID1(args);

        BDCurrencyReciver x = new BDCurrencyReciver();

        if (Options.dateInsert(args) != null){
            Dom.parseForDatabase(Options.dateInsert(args));
            System.out.println("База данных дополнена данными за "+ Options.dateInsert(args));
        }
        else {
            Valute optionalValute = x.getCurrencyByDateAndCode(date, currencuID);
            Valute v = optionalValute;
            System.out.println(v.toString());
            ValuteWriter.write(args, v);

        }

    }
}
