import Parsers.GismeteoParser;
import Parsers.MeteoProgParser;
import Parsers.SinopticParser;
import Parsers.WeatherParser;
import Services.ChartService;


public class Main {

    public static void main(String[] args) {
        // Creating parsers
       WeatherParser meteoProgParser = new MeteoProgParser();
       WeatherParser gismeteoParser = new GismeteoParser();
       WeatherParser sinopticParser = new SinopticParser();

       ChartService chart = new ChartService("Created by Roman Korets");
       chart.loadParser(gismeteoParser);
       chart.loadParser(meteoProgParser);
       chart.loadParser(sinopticParser);
       // Showing a chart
       chart.Show();
    }
}
