package andr.springframework.repositories;

import andr.springframework.domain.Statistics;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsRepositoryTest {
    
    private StatisticsRepository statisticsRepository;

    @Autowired
    public void setStatisticsRepository(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Test
    public void testSaveStatistics(){
        Statistics stats = new Statistics();
        stats.setId(1);

        Statistics statistics = statisticsRepository.findById(1).orElse(null);
        assertNotNull(statistics);
        assertEquals(statistics.getId(), stats.getId());
        assertEquals(statistics.getCount_requests(), stats.getCount_requests());
        assertEquals(statistics.getHits(), stats.getHits());
        assertEquals(statistics.getMisses(), stats.getMisses());
        statistics.setCount_requests();
        statistics.setHits();
        statistics.setMisses();
        statisticsRepository.save(statistics);

        Statistics updatedStatistics = statisticsRepository.findById(1).orElse(null);
        assertEquals(statistics.getCount_requests(), updatedStatistics.getHits());
        assertEquals(statistics.getHits(), updatedStatistics.getHits());
        assertEquals(statistics.getMisses(), updatedStatistics.getMisses());

    }
}
