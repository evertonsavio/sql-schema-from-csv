package dev.evertonsavio.moviesservice.repositories;

import dev.evertonsavio.moviesservice.entities.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Long> {

    @Query(value = "SELECT * FROM producer where MIN_INTERVAL = (SELECT MIN(MIN_INTERVAL) FROM producer where MIN_INTERVAL is not null)", nativeQuery = true)
    List<Producer> findAllProducersWithMinInterval();

    @Query(value = "SELECT * FROM producer where MAX_INTERVAL = (SELECT MAX(MAX_INTERVAL) FROM producer where MAX_INTERVAL is not null)", nativeQuery = true)
    List<Producer> findAllProducersWithMaxInterval();
}
