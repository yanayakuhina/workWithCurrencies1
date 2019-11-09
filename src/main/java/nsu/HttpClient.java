package nsu;

import kong.unirest.Unirest;



public class HttpClient {

    public static String doGet(String url, String arg1, String date){
        return Unirest.get(url).queryString(arg1, date).asString().getBody();
    }
}
