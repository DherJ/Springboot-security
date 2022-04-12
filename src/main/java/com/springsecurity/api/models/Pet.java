package com.springsecurity.api.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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
