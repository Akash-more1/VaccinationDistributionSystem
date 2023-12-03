package com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CenterNameVsDoctorCountDTO {

    int vcid;
    int docCount;
}
