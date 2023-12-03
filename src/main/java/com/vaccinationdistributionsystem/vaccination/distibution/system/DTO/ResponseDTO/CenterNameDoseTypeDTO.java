package com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.ResponseDTO;

import com.vaccinationdistributionsystem.vaccination.distibution.system.Enums.VaccinationPrefrence;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterNameDoseTypeDTO {

    String centerName;

    VaccinationPrefrence doseType;

    int doseCount;
}
