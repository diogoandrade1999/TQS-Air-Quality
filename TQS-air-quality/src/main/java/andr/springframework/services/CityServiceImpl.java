package andr.springframework.services;

import andr.springframework.domain.City;
import andr.springframework.repositories.CityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Iterable<City> listAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public City getCityById(Integer id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public long count(){
        return cityRepository.count();
    }
}
