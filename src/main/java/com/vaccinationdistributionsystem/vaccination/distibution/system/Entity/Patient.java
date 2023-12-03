package com.vaccinationdistributionsystem.vaccination.distibution.system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int pid;

    String name;
    String vaccinationPrefrence;
    String centerPrefrence;

    @Column(unique = true)
    int phoneNumber;

    @Column(unique = true)
    String emailAddress;

    //@JsonIgnore
   @ManyToOne
   @JsonManagedReference
    VaccinationCenter vaccinationCenter;

    //@JsonIgnore

    @ManyToOne
    @JsonManagedReference
     Doctor doctor;


     @OneToOne
    Certificates certificates;

}
