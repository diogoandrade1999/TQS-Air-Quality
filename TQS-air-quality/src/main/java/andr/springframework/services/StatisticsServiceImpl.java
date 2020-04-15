package andr.springframework.services;

import andr.springframework.domain.Statistics;
import andr.springframework.repositories.StatisticsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private StatisticsRepository statisticsRepository;

    @Autowired
    public void setStatisticsRepository(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public Statistics getStatisticsById(Integer id) {
        return statisticsRepository.findById(id).orElse(null);
    }


    @Override
    public Statistics saveStatistics(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    @Override
    public void deleteById(Integer id) {
        statisticsRepository.deleteById(id);
    }

}
