package dev.evertonsavio.moviesservice.repositories;

import dev.evertonsavio.moviesservice.entities.Producer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProducerRepository extends CrudRepository<Producer, Long> {

    @Query(value = "SELECT * FROM PRODUCER where MIN_INTERVAL is not null", nativeQuery = true)
    List<Producer> findAllProducersWithAwardsInterval();
}
