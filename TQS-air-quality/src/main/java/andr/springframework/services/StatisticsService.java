package andr.springframework.services;

import andr.springframework.domain.Statistics;

public interface StatisticsService {
    Statistics getStatisticsById(Integer id);
    Statistics saveStatistics(Statistics statistics);
    void deleteById(Integer id);
}
