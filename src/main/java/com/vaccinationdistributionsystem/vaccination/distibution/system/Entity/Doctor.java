package com.vaccinationdistributionsystem.vaccination.distibution.system.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int docid;

    String docName;

    String docDegree;

    int patientCount;

    @OneToMany(mappedBy = "doctor")
    @JsonBackReference
     List <Patient> patient;

    @JsonBackReference
    @ManyToOne
    VaccinationCenter vaccinationCenter;
}
