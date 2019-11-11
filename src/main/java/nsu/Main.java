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
//        ValuteWriter.write(args);
//        Valute valute = Dom.parse(Request.makeARequest(args), args);
//        System.out.println(valute);

        Date date = new Date();
        Options options = new Options();
        String cur = options.getCurrencyID1(args);
        date = options.getDate1(args);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String stringDate = dateFormat.format(date);
        Optional<Valute> valute = Database.select(stringDate,cur );

        Optional<Valute> valute1 = Database.select("2019-11-10", "RUB");
        System.out.println(valute1);

    }


}
