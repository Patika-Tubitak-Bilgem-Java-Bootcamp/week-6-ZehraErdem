package com.example.week6.components;

import lombok.Getter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Accessors(fluent = true)
public class CarRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String name;

    @OneToMany(mappedBy = "carRent")
    private Set<Car> cars;

    public CarRent(String name, String city) {
        this.city = city;
        this.name = name;
        cars = new HashSet<>();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarRent that = (CarRent) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
