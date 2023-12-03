package com.vaccinationdistributionsystem.vaccination.distibution.system.DTO;

import com.vaccinationdistributionsystem.vaccination.distibution.system.Enums.CenterPrefrence;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddVaccinationCenterDTO {
    String centerName;
    String address;
    int covaxinDoses;

    int covishieldDose;

    int  sputnicDoses;

    CenterPrefrence type;
}
