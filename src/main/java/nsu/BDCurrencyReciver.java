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
import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class BDCurrencyReciver extends CBCurrencyReciver implements CurrencyReciver {
    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";

    public   Valute getCurrencyByDateAndCode(String date, String currencyID) throws ParseException, ParserConfigurationException, IOException, SAXException {

        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
    try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD)) {
        PreparedStatement statement = connection
                .prepareStatement("SELECT * FROM `valute` WHERE `valute_date` = ? AND `char_code` = ?");
        statement.setString(1, date);
        statement.setString(2, currencyID);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            Valute valute = new Valute();
            valute.setId(resultSet.getLong("id"));
            valute.setCharCode(resultSet.getString("char_code"));
            valute.setName(resultSet.getString("name"));
            valute.setNominal(resultSet.getString("nominal"));
            valute.setValue(resultSet.getString("value"));
            valute.setDate(resultSet.getString("valute_date"));
            return valute;
        }
        else {
            return super.getCurrencyByDateAndCode(date, currencyID);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
    }
    return null;
}

}



