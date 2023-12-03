package com.vaccinationdistributionsystem.vaccination.distibution.system.Service;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.ResponseDTO.CenterNameVsDoctorCountDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Doctor;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.DoctorRepository;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;
    public void addDoctor(AddDoctorDTO obj){
        Doctor doctor=new Doctor();

        doctor.setDocName(obj.getName());

        doctor.setDocDegree(obj.getDegree());


        List<Object[]> list= doctorRepository.findMinDoctorCountVaccinationCenter();

        Object[] minVcid=list.get(0);

        int minId=Integer.parseInt(minVcid[0].toString()) ;

        VaccinationCenter temp=vaccinationCenterRepository.findById(minId).orElse(null);
        doctor.setVaccinationCenter(temp);

        doctorRepository.save(doctor);
    }
}
