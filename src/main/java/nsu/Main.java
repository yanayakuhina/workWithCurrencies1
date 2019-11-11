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
        ValuteWriter.write(args);

        String date = Options.getDate1(args);
        Optional<Valute> optionalValute = Database.select(date, "RUB");
        if (optionalValute.isPresent()) {
            Valute v = optionalValute.get();
            System.out.println(v);
        } else {
            Valute v = Dom.parse(Request.makeARequest(args), args);
            System.out.println(v);
        }

    }
}
