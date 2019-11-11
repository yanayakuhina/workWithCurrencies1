package nsu;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Options {

    static ArrayList<String> list(String[] args){
        ArrayList<String> s = new ArrayList<String>();
        for(String str: args){
            s.add(str);
        }
    return s;
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
}
