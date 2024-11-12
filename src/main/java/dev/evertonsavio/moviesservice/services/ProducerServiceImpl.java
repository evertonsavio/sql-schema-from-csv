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

        List<Producer> allProducersWithMinInterval = producerRepository.findAllProducersMinAndMaxIntervals();
        List<ProducerInterval> min = new ArrayList<>();
        List<ProducerInterval> max = new ArrayList<>();

        allProducersWithMinInterval.forEach(producer -> {
            ProducerInterval minProducerInterval = new ProducerInterval();
            if(producer.getX_type().equalsIgnoreCase("MIN")){
                minProducerInterval.setProducer(producer.getProducers());
                minProducerInterval.setInterval(producer.getX_interval());
                minProducerInterval.setPreviousWin(producer.getPrev_years());
                minProducerInterval.setFollowingWin(producer.getYears());
                min.add(minProducerInterval);
            } else {
                ProducerInterval maxProducerInterval = new ProducerInterval();
                maxProducerInterval.setProducer(producer.getProducers());
                maxProducerInterval.setInterval(producer.getX_interval());
                maxProducerInterval.setPreviousWin(producer.getPrev_years());
                maxProducerInterval.setFollowingWin(producer.getYears());
                max.add(maxProducerInterval);
            }
        });

        return new ProducerResponse(min, max);
    }
}
