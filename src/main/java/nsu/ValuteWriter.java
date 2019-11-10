package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ValuteWriter {


    public static void write(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        String s = Request.makeARequest(args);
        Map<String, String[]> states = new HashMap<String, String[]>();





    }
}
