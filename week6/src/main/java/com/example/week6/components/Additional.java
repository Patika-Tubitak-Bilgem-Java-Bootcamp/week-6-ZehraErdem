package com.example.week6.components;

import lombok.Getter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Accessors(fluent = true)
public class Additional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String details;
    private double price;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;


    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Additional that = (Additional) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
