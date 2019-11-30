package Parsers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class GismeteoParser implements WeatherParser {
    private String NameOfParser = "Gismeteo";

    public String getNameOfParser() {
        return NameOfParser;
    }

    public void setNameOfParser(String nameOfParser) {
        NameOfParser = nameOfParser;
    }

    public double getTemperature(){
        String urlGismeteo = "https://www.gismeteo.ua/weather-lutsk-4928/";
        Document documentGismeteo = null;
        try {
            documentGismeteo = Jsoup.connect(urlGismeteo).get();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Element temperatureGismeteo = documentGismeteo.getElementsByClass("js_value tab-weather__value_l").first();
        String tempGis = temperatureGismeteo.text();
        tempGis = tempGis.replace(',', '.');
        return Double.parseDouble(tempGis);
    }
}
