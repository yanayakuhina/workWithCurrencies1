package nsu;

import java.util.ArrayList;
import java.util.List;

public class Valute {

    private Long id;
    private String date;
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Valute{" +
                "charCode='" + charCode + '\'' +
                ", nominal='" + nominal + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", valutes=" + valutes +
                '}';
    }
}
