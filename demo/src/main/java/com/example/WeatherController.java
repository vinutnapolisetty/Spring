// package com.example;

// import javax.validation.constraints.NotBlank;
// import java.util.*;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.validation.annotation.Validated;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

package com.example;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
@RestController
@RequestMapping("/api/weather")
@Validated
public class WeatherController{
    private final WeatherService ws;
    @Autowired
    WeatherController(WeatherService ws)
    {
        this.ws=ws;
    }

    @GetMapping("/all")
    public List<WeatherRecord> getAllWeather()
    {
        return ws.getAllWeather();
    }
    @GetMapping("/{city}")
    public ResponseEntity<WeatherRecord> getWeatherByCity(@PathVariable @NotBlank String city)
    {
        WeatherRecord wr=ws.getWeatherByCity(city);
        return wr!=null ? ResponseEntity.ok(wr):ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<WeatherRecord> updateWeather(@PathVariable Long id, @RequestBody WeatherRecord wr){
        if(!ws.getAllWeather().stream().anyMatch(weather -> weather.getId().equals(id))){
            return ResponseEntity.notFound().build();
        }
        wr.setId(id);
        return ResponseEntity.ok(ws.updateWeather(wr));
    }
    @PostMapping("/create")
    public WeatherRecord addWeather(@Valid @RequestBody WeatherRequestDTO weatherRequestDTO){
         return ws.addWeather(weatherRequestDTO);
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeather(@PathVariable Long id){
        if(!ws.getAllWeather().stream().anyMatch(weather -> weather.getId().equals(id))){
            return ResponseEntity.notFound().build();
        }
        ws.deleteWeather(id);
        return ResponseEntity.noContent().build();
    }

}
// public class WeatherController {
//     private final WeatherService ws;
//     @Autowired
//     WeatherController(WeatherService ws)
//     {
//         this.ws=ws;
//     }
//     @GetMapping("/{city}")
//     public String getWeather(@PathVariable @NotBlank String city)
//     {
//         return ws.getWeather(city);
//         //return "The weather in "+ city +" is nice today";
//     }
//     @PostMapping("/{city}")
//     public String updateWeather(@PathVariable String city, @RequestParam int temperature) {
//         ws.updateWeather(city, temperature);
//         return "Weather updated for " + city;
//     }
//     @GetMapping
//     public Map<String, String> getAllWeather() {
//         return ws.getAllWeatherData();
//     }
//     // public String updateWeather(@PathVariable String city, @PathVariable String condition)
//     // {
//     //     ws.updateWeather(city, condition);
//     //     return "Weather updated for "+ city;
//     // }


//     // @GetMapping("/api/weather/{city}/{degree}")
//     // public String getWeather(@PathVariable String city,@PathVariable int degree)
//     // {
//     //     return "The weather in "+ city +" is "+degree+" degree celsius today";
//     // }

// }
