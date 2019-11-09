package nsu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Request {

    public static String makeARequest(String[] args) throws ParseException {
        String URL = "http://www.cbr.ru/scripts/XML_daily.asp";
        Date date = new Date();
        Optins optins = new Optins();
        date = optins.getDate(args);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String stringDate = dateFormat.format(date);
        String stringXml = HttpClient.doGet(URL,"date_req", stringDate);
        return stringXml;
    }
}
