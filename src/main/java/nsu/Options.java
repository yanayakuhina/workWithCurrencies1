package nsu;

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
    static Date getDate(String[] args) throws ParseException {
        int x = Options.list(args).indexOf("-d");
        String s = Options.list(args).get(x+1);
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy-MM-dd");
        Date docDate= format.parse(s);
        return docDate;
    }
    static String getNameFile(String[] args){
        int x = Options.list(args).indexOf("-f");
        return Options.list(args).get(x+1);
    }
    public static String getCurrencyID(String[] args){
        int x = Options.list(args).indexOf("-c");
        return Options.list(args).get(x+1);
    }
}
