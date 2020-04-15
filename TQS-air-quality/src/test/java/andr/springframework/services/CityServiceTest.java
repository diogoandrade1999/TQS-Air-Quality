package andr.springframework.services;

import andr.springframework.domain.City;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityServiceTest {

    @Autowired
    private CityService cityService;

    @Test
    public void getCityDetails_returnsCityInfo() {
        City city = new City();
        city.setId(1);
        city.setName("Porto");
        cityService.saveCity(city);
        City getCity = cityService.getCityById(1);
        assertEquals(getCity.getName(), city.getName());
    }

}

