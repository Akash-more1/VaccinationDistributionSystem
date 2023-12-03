package com.vaccinationdistributionsystem.vaccination.distibution.system.DTO;

import com.vaccinationdistributionsystem.vaccination.distibution.system.Enums.CenterPrefrence;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Enums.VaccinationPrefrence;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddPatientDTO {

String name;
CenterPrefrence centerPrefrence;
VaccinationPrefrence vaccinationPrefrence;
int phoneNumber;
String email;
}
