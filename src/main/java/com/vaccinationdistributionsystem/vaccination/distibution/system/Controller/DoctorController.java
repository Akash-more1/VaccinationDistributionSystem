package com.vaccinationdistributionsystem.vaccination.distibution.system.Controller;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/api/doctor/addDoctor")
    public String addDoctor(@RequestBody AddDoctorDTO doctorDTO){
        doctorService.addDoctor(doctorDTO);
        return "doctor"+doctorDTO.getName()+" get added successfully";
    }
}
