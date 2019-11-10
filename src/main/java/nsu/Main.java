package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;


public class Main {


    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
//        ValuteWriter.write(args);
//        Valute valute = Dom.parse(Request.makeARequest(args), args);
//        System.out.println(valute);
        Optional<Valute> valute = Database.select("2019-11-10", "RUB");
        System.out.println(valute);

    }


}
