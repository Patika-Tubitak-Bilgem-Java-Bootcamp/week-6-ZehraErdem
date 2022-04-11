package com.example.week6.components;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Accessors(fluent = true)
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    public Car(String type) {
        this.type = type;
        dailyPrices = new HashSet<>();
        availabilities = new HashSet<>();
        additionalServices = new HashSet<>();
    }

    @ManyToOne
    @JoinColumn(name = "car_rent_id")
    private CarRent carRent;

    @OneToMany(mappedBy = "car")
    private Set<DailyPrice> dailyPrices;

    @OneToMany(mappedBy = "car")
    private Set<Availability>  availabilities;

    @OneToMany(mappedBy = "car")
    private Set<Additional>  additionalServices;


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car that = (Car) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
