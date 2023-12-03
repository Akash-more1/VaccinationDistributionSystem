package com.vaccinationdistributionsystem.vaccination.distibution.system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vcid;

    String centerName;
    int covaxinDose;
    int covishieldDose;
    int sputnikDose;

    String type;

   // @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "vaccinationCenter")
    List<Patient> patient;

    @JsonBackReference
    @OneToMany(mappedBy = "vaccinationCenter")
    List<Doctor> doctors;

    String address;
}
