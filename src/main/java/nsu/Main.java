package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        ValuteWriter.write(args);



    }


}
