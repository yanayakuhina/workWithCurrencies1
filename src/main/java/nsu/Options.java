package nsu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Options {

    static ArrayList<String> list(String[] args) throws IOException {
        ArrayList<String> s = new ArrayList<String>();
        for(String str: args){
            s.add(str);
        }
        if (s.size() != 6 & s.size() !=2){
            throw new IOException(String.valueOf(s.size()));
        }
        else {return s;}
    }
    static String getDate1(String[] args) throws ParseException, IOException {
        int x = Options.list(args).indexOf("-d");
        String s = Options.list(args).get(x+1);
        if(s == ""){
            throw new IOException("Идентификатор пустой валюты\n");
        }
        else {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            Date docDate = format.parse(s);
            return s;
        }
    }
    static String getNameFile(String[] args) throws IOException {
        int x = Options.list(args).indexOf("-f");
        if (Options.list(args).get(x+1) == null){
            throw new IOException("Нет даты\n" );
        }
        else{
            return Options.list(args).get(x + 1);
        }
    }
    public static String getCurrencyID1(String[] args) throws IOException {
        int x = Options.list(args).indexOf("-c");

        if (Options.list(args).get(x+1) == null){
            throw new IOException("Ошибка\n" );
        }
        else{
            return Options.list(args).get(x + 1);
        }
    }
    public static String dateInsert(String[] args) throws IOException {
        int x = Options.list(args).indexOf("-d");
        if (args.length == 2) {
            return Options.list(args).get(x + 1);
        }
        if (Options.list(args).get(x+1) == null){
            throw new IOException("Ошибка\n" );
        }
        return null;
    }
}
