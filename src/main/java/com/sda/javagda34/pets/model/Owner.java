package com.sda.javagda34.pets.model;

import lombok.*;
import org.hibernate.annotations.Formula;

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
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER )
    @EqualsAndHashCode.Exclude
    private Set<Pet> pets = new HashSet<>();
    @Formula("select count(*) from Pet p where p.ownerId=id")
    private Double numOfPets;
    @Formula(value="(select avg(p.petAge) from Pet p where p.ownerId=id)")
    private Double avgPetsAge;
}
