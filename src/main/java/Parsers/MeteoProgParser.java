package Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MeteoProgParser implements WeatherParser{
    private String NameOfParser = "MeteoProg";

    public String getNameOfParser() {
        return NameOfParser;
    }

    public void setNameOfParser(String nameOfParser) {
        NameOfParser = nameOfParser;
    }

    public double getTemperature(){
        String urlMeteoProg = "https://www.meteoprog.ua/ru/weather/Lutsk/";
        Document documentMeteoProg = null;
        try {
            documentMeteoProg = Jsoup.connect(urlMeteoProg).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element temperatureMeteoProg = documentMeteoProg.getElementsByClass("temperature_value").first();
        String tempMeteoProg = temperatureMeteoProg.text();
        return Double.parseDouble(tempMeteoProg);
    }
}
