package andr.springframework.loader;

import andr.springframework.domain.Statistics;
import andr.springframework.repositories.StatisticsRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class StatisticsLoader implements ApplicationListener<ContextRefreshedEvent> {

    private StatisticsRepository statisticsRepository;

    private Logger log = LogManager.getLogger(StatisticsLoader.class);

    @Autowired
    public void setCityRepository(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Statistics statistics = new Statistics();
        statistics.setId(1);
        statisticsRepository.save(statistics);
        log.info("save statistics! ->" + statisticsRepository.findById(1));
    }

}
