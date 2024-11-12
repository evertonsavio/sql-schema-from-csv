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
    private Integer x_interval;
    private String x_type;
    private Integer years;
    private Integer prev_years;

    public Producer() {
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

    public Integer getX_interval()
    {
        return x_interval;
    }

    public void setX_interval(Integer x_interval)
    {
        this.x_interval = x_interval;
    }

    public String getX_type()
    {
        return x_type;
    }

    public void setX_type(String x_type)
    {
        this.x_type = x_type;
    }

    public Integer getYears()
    {
        return years;
    }

    public void setYears(Integer years)
    {
        this.years = years;
    }

    public Integer getPrev_years()
    {
        return prev_years;
    }

    public void setPrev_years(Integer prev_years)
    {
        this.prev_years = prev_years;
    }
}
