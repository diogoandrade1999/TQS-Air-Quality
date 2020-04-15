package andr.springframework.controllers;

import andr.springframework.domain.City;
import andr.springframework.domain.Statistics;
import andr.springframework.repositories.CityRepository;
import andr.springframework.serializers.DataSerializerAir;
import andr.springframework.serializers.DataSerializer;
import andr.springframework.services.CityService;

import andr.springframework.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.client.RestTemplate;

import java.util.*;

@Controller
public class CityController {

    private CityService cityService;
    private StatisticsService statisticsService;

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    @Autowired
    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value = "cities", method = RequestMethod.POST)
    public String cities(City city, Model model){
        model.addAttribute("city_search", new City());
        model.addAttribute("msg", "Error load data!");
        try {
            String url = "https://api.waqi.info/search/?token=5122b52d41f0fa2fb2577729717024b366c340bf&keyword=" + city.getName();
            RestTemplate restTemplate = new RestTemplate();
            DataSerializer cities = restTemplate.getForObject(url, DataSerializer.class);
            model.addAttribute("msg", "Not Found Cities!");
            assert cities != null;
            if (cities.getStatus().equals("ok")) {
                model.addAttribute("cities", cities.getData());
                if(cities.getData().size() != 0)
                    model.addAttribute("msg", "");
            } else {
                List<DataSerializer> c = new ArrayList<>();
                model.addAttribute("cities", c);
            }
        }catch (Exception e){
            System.out.println("Error load data!");
        }
        return "cities";
    }

    @RequestMapping(value = "city/{id}/{name}", method = RequestMethod.GET)
    public String city(@PathVariable Integer id, Model model, @PathVariable String name){
        model.addAttribute("city_search", new City());
        City city = cityService.getCityById(id);
        Statistics statistics = statisticsService.getStatisticsById(1);
        statistics.setCount_requests();
        if (city !=  null){
            statistics.setHits();
            model.addAttribute("city", city);
            model.addAttribute("msg", "Data From Repository!");
        }else{
            statistics.setMisses();
            model.addAttribute("city", null);
            model.addAttribute("msg", "Error load data!");
            try {
                String url="https://api.waqi.info/feed/@" + id + "/?token=5122b52d41f0fa2fb2577729717024b366c340bf";
                RestTemplate restTemplate = new RestTemplate();
                DataSerializerAir city_data = restTemplate.getForObject(url, DataSerializerAir.class);
                assert city_data != null;
                if(city_data.getStatus().equals("ok")) {
                    saveRepository(city_data, id, name);
                    model.addAttribute("city", cityService.getCityById(id));
                    model.addAttribute("msg", "Data From API! -> This data already in repository!");
                }else{
                    model.addAttribute("msg", "Not Found City!");
                }
            }catch (Exception e){
                System.out.println("Error load data!");
            }
        }
        statisticsService.saveStatistics(statistics);
        return "city";
    }

    private void saveRepository(DataSerializerAir city_data, Integer id, String name){
        City c = new City();
        c.setId(id);
        c.setName(name);
        if(city_data.getDew() != null)
            c.setDew(city_data.getDew());
        if(city_data.getH() != null)
            c.setHumidity(city_data.getH());
        if(city_data.getNo2() != null)
            c.setNo2(city_data.getNo2());
        if(city_data.getO3() != null)
            c.setO3(city_data.getO3());
        if(city_data.getP() != null)
            c.setPressure(city_data.getP());
        if(city_data.getPm10() != null)
            c.setPm10(city_data.getPm10());
        if(city_data.getPm25() != null)
            c.setPm25(city_data.getPm25());
        if(city_data.getSo2() != null)
            c.setSo2(city_data.getSo2());
        if(city_data.getT() != null)
            c.setTemperature(city_data.getT());
        if(city_data.getW() != null)
            c.setWind(city_data.getW());
        if(city_data.getWg() != null)
            c.setWg(city_data.getWg());
        cityService.saveCity(c);
    }

    @RequestMapping(value = "statistics", method = RequestMethod.GET)
    public String statistics(Model model){
        model.addAttribute("city_search", new City());
        model.addAttribute("statistics", statisticsService.getStatisticsById(1));
        model.addAttribute("count", cityService.count());
        model.addAttribute("cities", cityService.listAllCities());
        return "statistics";
    }
}
