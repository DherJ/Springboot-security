package com.springsecurity.api.models;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(	name = "pets")
@Getter
@Setter
public class Pet {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max = 20)
        private String name;

        @Size(max = 100)
        private String description;

        @Size(max = 20)
        private String species;

        private int weight;

        @ManyToMany(fetch = FetchType.EAGER)
        @Fetch(value= FetchMode.SELECT)
        @JoinTable(	name = "food_pets",
                joinColumns = @JoinColumn(name = "food_id"),
                inverseJoinColumns = @JoinColumn(name = "pet_id"))
        private List<Food> foodPreference = new ArrayList<>();
}
