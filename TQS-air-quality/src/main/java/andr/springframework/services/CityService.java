package andr.springframework.services;

import andr.springframework.domain.City;

public interface CityService {
    Iterable<City> listAllCities();
    City getCityById(Integer id);
    City saveCity(City city);
    long count();
}

