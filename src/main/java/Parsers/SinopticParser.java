package Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class SinopticParser implements WeatherParser {
    private String NameOfParser = "Sinoptic";

    public String getNameOfParser() {
        return NameOfParser;
    }

    public void setNameOfParser(String nameOfParser) {
        NameOfParser = nameOfParser;
    }

    public double getTemperature(){
        String urlSinoptic = "https://sinoptik.ua/%D0%BF%D0%BE%D0%B3%D0%BE%D0%B4%D0%B0-%D0%BB%D1%83%D1%86%D0%BA";
        Document documentSinoptic = null;
        try {
            documentSinoptic = Jsoup.connect(urlSinoptic).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element temperatureSinoptic = documentSinoptic.getElementsByClass("today-temp").first();
        String tempSin = temperatureSinoptic.text();
        String sign = tempSin.substring(0, 1);
        String number = tempSin.substring(1, tempSin.length() - 2);
        if (sign.charAt(0) == '+'){
            return Double.parseDouble(number);
        }
        else {
            return Double.parseDouble(number ) * (-1);
        }
    }
}
