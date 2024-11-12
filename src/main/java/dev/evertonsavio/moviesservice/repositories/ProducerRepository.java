package dev.evertonsavio.moviesservice.repositories;

import dev.evertonsavio.moviesservice.entities.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Long> {

    @Query(value = "WITH producer_intervals as (\n" +
            "    SELECT\n" +
            "         id,\n" +
            "         producers,\n" +
            "         (years - LAG(years) OVER (PARTITION BY producers ORDER BY years)) as x_interval,\n" +
            "         years,\n" +
            "         LAG(years, 1) OVER (PARTITION BY producers ORDER BY years) as prev_years,\n" +
            "     FROM awards\n" +
            "     WHERE producers IN (SELECT producers FROM awards WHERE winner = 'yes'\n" +
            "     GROUP BY producers HAVING COUNT(producers) > 1)\n" +
            "     ORDER BY producers, years\n" +
            " ) SELECT id,\n" +
            "        producers,\n" +
            "        x_interval,\n" +
            "        years,\n" +
            "        prev_years,\n" +
            "     CASE\n" +
            "        WHEN x_interval = (SELECT MIN(x_interval) FROM producer_intervals) THEN 'MIN'\n" +
            "         ELSE 'MAX'\n" +
            "     END as X_TYPE FROM producer_intervals\n" +
            "     WHERE x_interval = (SELECT MIN(x_interval) FROM producer_intervals) OR x_interval = (SELECT MAX(x_interval) FROM producer_intervals)", nativeQuery = true)
    List<Producer> findAllProducersMinAndMaxIntervals();
}
