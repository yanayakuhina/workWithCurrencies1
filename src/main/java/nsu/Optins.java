package nsu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Optins {



    static ArrayList<String> list(String[] args){
        ArrayList<String> s = new ArrayList<String>();
        for(String str: args){
            s.add(str);
        }
    return s;
    }
    static Date getDate(String[] args) throws ParseException {
        int x = Optins.list(args).indexOf("-d");
        String s = Optins.list(args).get(x+1);
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date docDate= format.parse(s);
        return docDate;
    }
    static String getNameFile(String[] args){
        int x = Optins.list(args).indexOf("-f");
        return Optins.list(args).get(x+1);
    }
    public static String getCurrencyID(String[] args){
        int x = Optins.list(args).indexOf("-c");
        return Optins.list(args).get(x+1);
    }
}
