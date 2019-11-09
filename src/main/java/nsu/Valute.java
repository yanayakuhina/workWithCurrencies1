package nsu;

import java.util.ArrayList;
import java.util.List;

public class Valute {

    private String charCode, nominal, name, value;

    public final List<String> valutes = new ArrayList<String>();

    public void addValute(String v){
        valutes.add(v);
    }

    public Valute(String charCode, String nominal, String name, String value){
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public Valute(){
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getCharCode() {
        return charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public String setCharCode(String charCode) {
        this.charCode = charCode;
        return charCode;

    }

    public String setNominal(String nominal) {
        this.nominal = nominal;
        return nominal;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setValue(String value) {
        this.value = value;
        return value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }



}
