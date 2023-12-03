package com.vaccinationdistributionsystem.vaccination.distibution.system.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddDoctorDTO {

    String name;
    String degree;

}
