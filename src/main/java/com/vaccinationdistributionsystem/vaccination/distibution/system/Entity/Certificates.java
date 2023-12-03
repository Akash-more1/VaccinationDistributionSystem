package com.vaccinationdistributionsystem.vaccination.distibution.system.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Certificates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cid;

    @OneToOne
    @JoinColumn(unique = true)
    Patient patient;
}
