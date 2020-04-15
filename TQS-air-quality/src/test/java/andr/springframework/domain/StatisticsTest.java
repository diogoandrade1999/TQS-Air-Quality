package andr.springframework.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsTest {

    @Test
    public void testSaveStatistics() {
        Statistics statistics = new Statistics();
        statistics.setId(1);
        statistics.setCount_requests();
        statistics.setHits();
        statistics.setMisses();

        assertEquals(java.util.Optional.ofNullable(statistics.getId()), java.util.Optional.ofNullable(1));
        assertEquals(java.util.Optional.ofNullable(statistics.getCount_requests()), java.util.Optional.ofNullable(1));
        assertEquals(java.util.Optional.ofNullable(statistics.getHits()), java.util.Optional.ofNullable(1));
        assertEquals(java.util.Optional.ofNullable(statistics.getMisses()), java.util.Optional.ofNullable(1));
    }
}
