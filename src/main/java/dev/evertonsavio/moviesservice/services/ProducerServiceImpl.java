package dev.evertonsavio.moviesservice.services;

import dev.evertonsavio.moviesservice.entities.Producer;
import dev.evertonsavio.moviesservice.models.ProducerInterval;
import dev.evertonsavio.moviesservice.models.ProducerResponse;
import dev.evertonsavio.moviesservice.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public ProducerResponse getProducersAwardsInterval() {

        List<Producer> allProducersWithMinInterval = producerRepository.findAllProducersWithMinInterval();
        List<Producer> allProducersWithMaxInterval = producerRepository.findAllProducersWithMaxInterval();
        List<ProducerInterval> min = new ArrayList<>();
        List<ProducerInterval> max = new ArrayList<>();

        allProducersWithMinInterval.forEach(producer -> {
            ProducerInterval minProducerInterval = new ProducerInterval();
            minProducerInterval.setProducer(producer.getProducers());
            minProducerInterval.setInterval(producer.getMin_interval());
            minProducerInterval.setPreviousWin(producer.getMin_previous_year());
            minProducerInterval.setFollowingWin(producer.getMin_following_year());
            min.add(minProducerInterval);
        });
        allProducersWithMaxInterval.forEach(producer -> {
            ProducerInterval maxProducerInterval = new ProducerInterval();
            maxProducerInterval.setProducer(producer.getProducers());
            maxProducerInterval.setInterval(producer.getMax_interval());
            maxProducerInterval.setPreviousWin(producer.getMax_previous_year());
            maxProducerInterval.setFollowingWin(producer.getMax_following_year());
            max.add(maxProducerInterval);
        });

        return new ProducerResponse(min, max);
    }
}
