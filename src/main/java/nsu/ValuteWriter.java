package nsu;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ValuteWriter {


    public static void write(String[] args, Valute valute) throws ParseException, IOException, SAXException, ParserConfigurationException {
        String sFile = Options.getNameFile(args);
        String result = valute.getNominal() + " " + valute.getName() + " равен " + valute.getValue() + " Российских рубля.";
        File file = new File(sFile);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(result);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
