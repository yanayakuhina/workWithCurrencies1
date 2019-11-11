package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Formatter;


public class Main {


    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        String date = Options.getDate1(args);
        String cur = Options.getCurrencyID1(args);
        Valute optionalValute = Database.select(date, cur);
        if (optionalValute != null) {
            Valute v = optionalValute;
            System.out.println(v.getName());
            ValuteWriter.write(args, v);
        } else {
            Valute v = Dom.parse(Request.makeARequest(args), args);
            System.out.println(v.getName());
            ValuteWriter.write(args, v);
        }
    }
}
