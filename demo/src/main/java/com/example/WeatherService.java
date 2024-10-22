package com.example;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.transaction.Transactional;


@Service
@Validated
public class WeatherService{
    public final WeatherRepository wr;
    private final WeatherValidator weatherValidator;
    @Autowired
    public WeatherService(WeatherRepository wr,WeatherValidator weatherValidator)
    {
        this.wr=wr;
        this.weatherValidator=weatherValidator;
    }
    public List<WeatherRecord> getAllWeather()
    {
        return wr.findAll();
    }
    public WeatherRecord getWeatherByCity(String city)
    {
        return wr.findByCity(city).orElseThrow(()-> new RuntimeException("City not found"));
    }
    private WeatherRecord convertToEntity(WeatherRequestDTO weatherRequestDTO)
    {
        WeatherRecord wr2=new WeatherRecord();
        wr2.setCity(weatherRequestDTO.getCity());
        wr2.setTemp(weatherRequestDTO.getTemp());
        wr2.setWeathercondition(weatherRequestDTO.getWeatherCondition());
        return wr2;
    }
    @Transactional
    public WeatherRecord addWeather(WeatherRequestDTO weatherRequestDTO)
    {
        weatherValidator.validateWeatherCond(weatherRequestDTO);
        WeatherRecord wr1=convertToEntity(weatherRequestDTO);
        return wr.save(wr1);
        
    }
    public void deleteWeather(Long id){
        wr.deleteById(id);
    }
    public WeatherRecord updateWeather(WeatherRecord weatherRecord){
        return wr.save(weatherRecord);
    }

}



// import java.util.*;


// //import org.apache.catalina.core.ApplicationContext;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.context.ApplicationContext;
// @Service
// public class WeatherService {
//    // private Map<String,String> mp=new HashMap<>();
//     private final WeatherConfig wc;
//     private final ApplicationContext context;
//    // private final WeatherRecord wr;

//     private final Map<String, WeatherRecord> mp = new HashMap<>();
//     @Autowired
//     // public WeatherService(WeatherConfig wc, WeatherRecord wr)
//     // {
//     //     this.wc=wc;
//     //     this.wr=wr;
//     // }
//     public WeatherService(WeatherConfig wc, ApplicationContext context) {
//         this.wc = wc;
//         this.context = context;
//     }
//    // private Map<String,WeatherRecord> mp=new HashMap<>();
   
// //     public String getWeather(String city)
// //     {
// //         if(mp.containsKey(city))
// //         {
// //             System.out.println("Contains");
// //             //return mp.get(city);
// //             return mp.get(city).getCondition();
// //         }
// //        //System.out.println(wc.getDefaultCond());
// //         else
// //         return wc.getDefaultCond();
// //    // return mp.getOrDefault(city, wc.getDefaultCond());
// //         // return mp.getOrDefault(city, "Weather data not available for "+city);
// //     }
// public String getWeather(String city) {
//     WeatherRecord record = mp.get(city);
//     if (record == null) {  // If city data not found, return default condition
//         return wc.getDefaultCond();
//     }
//     return String.format("The temperature in %s is %d°C. Condition: %s", city, record.getTemp(), record.getCond());
// }
//     // public void updateWeather(String city,String condition)
//     // {
//     //     if(condition!=null)
//     //     {
//     //     //mp.put(city, condition);
//     //     wr.initialize(city, condition);
//     //     mp.put(city,wr);
//     //     }
//     //     else
//     //     {
//     //    // mp.put(city,wc.getDefaultCond());
//     //    wr.initialize(city, wc.getDefaultCond());
//     //    mp.put(city,wr);
//     //     }
//     // }
//     public void updateWeather(String city, int temperature) {
//         WeatherRecord record = mp.computeIfAbsent(city, k -> {
//             WeatherRecord newRecord = context.getBean(WeatherRecord.class);  // Create new WeatherRecord
//             newRecord.initialize(city, temperature);
//             return newRecord;
//         });
//         record.setTemp(temperature);
//         record.setCond(determineCondition(city, temperature));
//     }
//     // Helper method to determine weather condition based on temperature range
//     private String determineCondition(String city, int temperature) {
//         WeatherConfig.TempRange range = wc.getCityTemp().get(city);
//         if (range == null) {
//             return wc.getDefaultCond();  // Default if no city-specific range
//         }
//         if (temperature < range.getMin()) {
//             return "Cold";
//         } else if (temperature > range.getMax()) {
//             return "Hot";
//         } else {
//             return "Pleasant";
//         }
//     }
//     public Map<String, String> getAllWeatherData() {
//         Map<String, String> result = new HashMap<>();
//         mp.forEach((city, record) -> 
//             result.put(city, String.format("%d°C, %s", record.getTemp(), record.getCond()))
//         );
//         return result;
//     }
// }
