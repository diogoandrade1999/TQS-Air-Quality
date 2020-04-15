package andr.springframework.repositories;

import andr.springframework.domain.City;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class CityRepositoryTest {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCity_returnsCityDetails() {
        City city = new City();
        city.setId(1);
        city.setName("Aveiro");
        City savedcity = entityManager.persistAndFlush(city);

        City getCity = cityRepository.findById(1).orElse(null);

        Assertions.assertThat(getCity.getName()).isEqualTo(savedcity.getName());
    }

    @Test
    public void testSaveCity(){
        City city = new City();
        city.setId(2);
        city.setName("Lisboa");
        city.setDew(15.0);
        city.setHumidity(82.0);
        city.setNo2(13.9);
        city.setO3(14.3);
        city.setPressure(1020.0);

        assertNull(cityRepository.findById(city.getId()).orElse(null));
        cityRepository.save(city);
        assertNotNull(city.getId());

        City fetchedCity = cityRepository.findById(city.getId()).orElse(null);
        assertNotNull(fetchedCity);
        assertEquals(city.getId(), fetchedCity.getId());
        assertEquals(city.getName(), fetchedCity.getName());
        fetchedCity.setName("Olivais, Lisboa, Portugal");
        cityRepository.save(fetchedCity);

        City fetchedUpdatedCity = cityRepository.findById(fetchedCity.getId()).orElse(null);
        assertEquals(fetchedCity.getName(), fetchedUpdatedCity.getName());

        long cityCount = cityRepository.count();
        assertEquals(cityCount, 1);
        Iterable<City> cities = cityRepository.findAll();

        int count = 0;
        for(City c : cities){
            count++;
        }
        assertEquals(count, 1);
    }
}
