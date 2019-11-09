package nsu;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Dom {

    public String charCode;
    private String value;
   // Map<String, String[]>


    public  static Map<String, String[]> parse(String stringXml) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        Map<String, String[]> states = new HashMap<String, String[]>();



        DocumentBuilder builder = f.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(stringXml));
        Document document = builder.parse(is);

        NodeList valuteElement = document.getDocumentElement().getElementsByTagName("Valute");

        for (int i = 0; i < valuteElement.getLength(); i++) {
            Node valutelist = valuteElement.item(i);
            NodeList nodeList = valutelist.getChildNodes();
            Valute valute = new Valute();
            for (int j = 0; j < nodeList.getLength(); j++) {
                Node node = nodeList.item(j);
                String[] valutes = new String[3];
                String key = null;
                if (node.getNodeName().equals("CharCode")){
                    valute.setCharCode(node.getTextContent());
                    key = valute.setCharCode(node.getTextContent());

                }
                if (node.getNodeName().equals("Value")) {
                    String s = valute.setValue(node.getTextContent());
                    valutes[0] = s;
                }

                if (node.getNodeName().equals("Name")){
                    String s = valute.setName(node.getTextContent());
                    valutes[1] = s;

                }
                if (node.getNodeName().equals("Nominal")){
                    String s = valute.setNominal(node.getTextContent());
                    valutes[2] = s;

                }
                states.put(key, valutes);

            }


        }
        return states;
        }
    }


