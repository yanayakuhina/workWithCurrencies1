package nsu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Request {

    public static String makeARequest(String date) throws ParseException {
        String URL = "http://www.cbr.ru/scripts/XML_daily.asp";
        String stringDate = null;
        Options options = new Options();

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date docDate = format.parse(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        stringDate = dateFormat.format(docDate);

        return HttpClient.doGet(URL,"date_req", stringDate);
    }
}
