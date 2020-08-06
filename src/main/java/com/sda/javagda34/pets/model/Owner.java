package com.sda.javagda34.pets.model;

import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private double age;
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<Pet> pets = new HashSet<>();

   @Formula(value="(select count(p.id) from pet p where p.owner_id=id)")
    private Double numOfPets;
    @Formula(value="(select avg(p.age) from pet p where p.owner_id=id)")
    private Double avgPetsAge;
}
