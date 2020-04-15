package andr.springframework.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityTest {

    @Test
    public void testSaveCity() {
        City city = new City();
        city.setId(1);
        city.setName("Lisboa");
        city.setDew(1.0);
        city.setHumidity(1.0);
        city.setNo2(1.0);
        city.setO3(1.0);
        city.setPressure(1.0);

        assertEquals(java.util.Optional.ofNullable(city.getId()), java.util.Optional.ofNullable(1));
        assertEquals(city.getName(), "Lisboa");
        assertEquals(java.util.Optional.ofNullable(city.getDew()), java.util.Optional.ofNullable(1.0));
        assertEquals(java.util.Optional.ofNullable(city.getHumidity()), java.util.Optional.ofNullable(1.0));
        assertEquals(java.util.Optional.ofNullable(city.getNo2()), java.util.Optional.ofNullable(1.0));
        assertEquals(java.util.Optional.ofNullable(city.getO3()), java.util.Optional.ofNullable(1.0));
        assertEquals(java.util.Optional.ofNullable(city.getPressure()), java.util.Optional.ofNullable(1.0));
    }
}
