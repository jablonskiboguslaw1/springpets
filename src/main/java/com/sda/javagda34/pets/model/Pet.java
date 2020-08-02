package com.sda.javagda34.pets.model;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private double age;
    private double weight;
    @Enumerated(EnumType.STRING)
    private Race race;
    private boolean pureRace;
    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Owner owner;




}
