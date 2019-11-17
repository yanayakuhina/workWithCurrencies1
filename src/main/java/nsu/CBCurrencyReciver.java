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
import java.text.ParseException;

class CBCurrencyReciver implements CurrencyReciver  {

    public  Valute getCurrencyByDateAndCode(String date, String currencyID) throws ParseException, ParserConfigurationException, IOException, SAXException {
        System.out.println(currencyID);
        String stringXml = Request.makeARequest(date);
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = f.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(stringXml));
        Document document = builder.parse(is);

        NodeList valuteElement = document.getDocumentElement().getElementsByTagName("Valute");
        boolean x = false;
        for (int i = 0; i < valuteElement.getLength(); i++) {
            Node valutelist = valuteElement.item(i);
            NodeList nodeList = valutelist.getChildNodes();
            Valute valute = new Valute();
            for (int j = 0; j < nodeList.getLength(); j++) {
                Node node = nodeList.item(j);

                if (node.getNodeName().equals("CharCode")) {
                    if (node.getTextContent().equals(currencyID)) {
                        x = true;
                        valute.setCharCode(node.getTextContent());
                    }
                }
                if (node.getNodeName().equals("Value")) {
                    valute.setValue(node.getTextContent());
                }
                if (node.getNodeName().equals("Name")) {
                    valute.setName(node.getTextContent());
                }
                if (node.getNodeName().equals("Nominal")) {
                    valute.setNominal(node.getTextContent());
                }
            }

            if (x) {
                return valute;
            }
        }
        throw new RuntimeException("Не найден узел в DOM дереве для валюты " + currencyID);
    }
}


