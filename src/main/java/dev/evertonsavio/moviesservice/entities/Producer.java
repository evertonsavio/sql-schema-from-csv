package dev.evertonsavio.moviesservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String producers;
    private Integer min_interval;
    private Integer max_interval;
    private Integer min_previous_year;
    private Integer max_previous_year;
    private Integer min_following_year;
    private Integer max_following_year;

    public Producer() {
    }

    public Producer(String producers, Integer min_interval, Integer max_interval, Integer min_previous_year,
                    Integer max_previous_year, Integer min_following_year, Integer max_following_year) {
        this.producers = producers;
        this.min_interval = min_interval;
        this.max_interval = max_interval;
        this.min_previous_year = min_previous_year;
        this.max_previous_year = max_previous_year;
        this.min_following_year = min_following_year;
        this.max_following_year = max_following_year;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getProducers()
    {
        return producers;
    }

    public void setProducers(String producers)
    {
        this.producers = producers;
    }

    public Integer getMin_interval()
    {
        return min_interval;
    }

    public void setMin_interval(Integer min_interval)
    {
        this.min_interval = min_interval;
    }

    public Integer getMax_interval()
    {
        return max_interval;
    }

    public void setMax_interval(Integer max_interval)
    {
        this.max_interval = max_interval;
    }

    public Integer getMin_previous_year()
    {
        return min_previous_year;
    }

    public void setMin_previous_year(Integer min_previous_year)
    {
        this.min_previous_year = min_previous_year;
    }

    public Integer getMax_previous_year()
    {
        return max_previous_year;
    }

    public void setMax_previous_year(Integer max_previous_year)
    {
        this.max_previous_year = max_previous_year;
    }

    public Integer getMin_following_year()
    {
        return min_following_year;
    }

    public void setMin_following_year(Integer min_following_year)
    {
        this.min_following_year = min_following_year;
    }

    public Integer getMax_following_year()
    {
        return max_following_year;
    }

    public void setMax_following_year(Integer max_following_year)
    {
        this.max_following_year = max_following_year;
    }
}
