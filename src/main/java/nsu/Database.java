package nsu;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

public class Database {
    private static final String NAME = "SG15DDhe11";
    private static final String URL = "jdbc:mysql://remotemysql.com/" + NAME;
    private static final String USER = "SG15DDhe11";
    private static final String PASSWORD = "k1Ehx8akH4";


    public static void insert(Valute valute){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD)) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Optional<Valute> select(String date, String charCode){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection =  DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM `valute` WHERE `valute_date` = ? AND `char_code` = ?");
            statement.setString(1, date);
            statement.setString(2, charCode);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Valute valute = new Valute();
                valute.setId(resultSet.getLong("id"));
                valute.setCharCode(resultSet.getString("char_code"));
                valute.setName(resultSet.getString("name"));
                valute.setNominal(resultSet.getString("nominal"));
                valute.setValue(resultSet.getString("value"));
                valute.setDate(resultSet.getString("valute_date"));

                return Optional.of(valute);
            }


        } catch (SQLException e) {
            System.out.println("Could not connect to database: " + e.getMessage());
            e.printStackTrace();
        }
        return Optional.empty();
    }
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
            System.out.println("Изменены " + rows + " строк");

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }

}
