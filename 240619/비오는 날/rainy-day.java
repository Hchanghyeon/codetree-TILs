import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;
    private static List<WeatherInfo> weatherInfos = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            parseLineAndAdd(line, i);
        }

        WeatherInfo min = weatherInfos.get(0);

        for(WeatherInfo weatherInfo : weatherInfos){
            if(min.getYear() > weatherInfo.getYear()){
                min = weatherInfo;
            }

            if(min.getYear() == weatherInfo.getYear()){
                if(min.getMonth() > weatherInfo.getMonth()){
                    min = weatherInfo;
                }

                if(min.getMonth() == weatherInfo.getMonth()){
                    if(min.getDay() > weatherInfo.getDay()){
                        min = weatherInfo;
                    }
                }
            }
        }

        System.out.println(min.toString());
    }

    private static void parseLineAndAdd(String[] line, int index){
        String[] date = line[0].split("-");

        String year = date[0]; 
        String month = date[1];
        String day = date[2];
        String dayOfWeek = line[1];
        String weather = line[2];
        
        if(weather.equals("Rain")){
            weatherInfos.add(new WeatherInfo(year, month, day, dayOfWeek, weather));
        }
    }

    static class WeatherInfo {
        private String year;
        private String month;
        private String day;
        private String dayOfWeek;
        private String weather;

        public WeatherInfo(String year, String month, String day, String dayOfWeek, String weather){
            this.year = year;
            this.month = month;
            this.day = day;
            this.dayOfWeek = dayOfWeek;
            this.weather = weather;
        }

        public int getYear(){
            return Integer.parseInt(year);
        }

        public int getMonth(){
            return Integer.parseInt(month);
        }

        public int getDay(){
            return Integer.parseInt(day);
        }

        public String getWeather(){
            return weather;
        }

        public String toString(){
            return year+"-"+month+"-"+day + " " + dayOfWeek + " " + weather;
        }
    }
}