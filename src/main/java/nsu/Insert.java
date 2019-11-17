package nsu;
import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;

import java.util.Locale;

public class Insert {
    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";


    public static void insert(String date, Valute valute){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection
                    .prepareStatement("INSERT INTO valute(valute_date, char_code, nominal, name, value) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, date);
            statement.setString(2, valute.getCharCode());
            statement.setString(3, valute.getNominal());
            statement.setString(4, valute.getName());
            NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
            Number number = format.parse(valute.getValue());
            statement.setDouble(5, number.doubleValue());
            int rows = statement.executeUpdate();


        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
