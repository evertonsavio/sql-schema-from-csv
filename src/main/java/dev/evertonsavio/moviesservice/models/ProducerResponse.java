package dev.evertonsavio.moviesservice.models;

import java.util.List;

public class ProducerResponse {

    private List<ProducerInterval> min;
    private List<ProducerInterval> max;

    public ProducerResponse() {
    }

    public ProducerResponse(List<ProducerInterval> min, List<ProducerInterval> max) {
        this.min = min;
        this.max = max;
    }

    public List<ProducerInterval> getMin() {
        return min;
    }

    public List<ProducerInterval> getMax() {
        return max;
    }
}
