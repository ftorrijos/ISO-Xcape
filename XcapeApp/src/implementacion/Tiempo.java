/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import com.teknikindustries.yahooweather.WeatherDisplay;
import com.teknikindustries.yahooweather.WeatherDoc;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.text.Document;
import org.dom4j.io.SAXReader;

public class Tiempo {

    public void tiempo() {
    }

    public void getWeather() {
        WeatherDoc doc = new WeatherDoc("23424744", "c");

        WeatherDisplay dis = new WeatherDisplay();

        String temp = dis.getTemperature();
        String hum = dis.getHumidity();
        String press = dis.getPressure();
        String sunup = dis.getSunrise();
        String sundown = dis.getSunset();
        String city = dis.getCity();
        String wind = dis.getWindSpeed();
        String visibility = dis.getVisibility();

        System.out.println("La ciudad es: " + city + "\n"
                + "La temperatura es: " + temp);

    }

    public void retrieve(String zipcode) throws Exception {

        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places%20where%20text%3D%27" + zipcode + "%27%20)";
        URLConnection conn = (URLConnection) new URL(url).openConnection();
        SAXReader reader = new SAXReader();

        String string = reader.read(conn.getInputStream()).getStringValue();
        String[] parts = string.split("<BR /> ");
        String part1 = parts[6]; 
        String part2 = parts[7];
        String part3 = parts[8];
        String part4 = parts[9]; 
        //https://www.yahoo.com/news/weather/singapore/north-west/sembawang-1062686/?unit=c
        System.out.println("Tiempo en Singapore, North West");
        System.out.println(part1);
        System.out.println(part2);
        System.out.println(part3);
        System.out.println(part4);
        

    }

}
