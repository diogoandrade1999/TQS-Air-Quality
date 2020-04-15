package andr.springframework.loader;

import andr.springframework.domain.City;
import andr.springframework.repositories.CityRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class CityLoader implements ApplicationListener<ContextRefreshedEvent> {

    private CityRepository cityRepository;

    private Logger log = LogManager.getLogger(CityLoader.class);

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        City lisboa = new City();
        lisboa.setId(8379);
        lisboa.setName("Entrecampos, Lisboa, Portugal");
        lisboa.setDew(15.0);
        lisboa.setHumidity(82.0);
        lisboa.setNo2(13.9);
        lisboa.setO3(14.3);
        lisboa.setPressure(1020.0);
        //cityRepository.save(lisboa);
        //log.info("Saved city - id: " + lisboa.getId());

    }
}
