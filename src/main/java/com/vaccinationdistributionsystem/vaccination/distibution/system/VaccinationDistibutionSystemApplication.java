package com.vaccinationdistributionsystem.vaccination.distibution.system;

import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Doctor;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Patient;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.DoctorRepository;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.PatientRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class VaccinationDistibutionSystemApplication {




	public static void main(String[] args) {

		SpringApplication.run(VaccinationDistibutionSystemApplication.class, args);


	}


//	@Override
//	public void run(String... args) throws Exception {
//
//		Patient patient= new Patient();
//		//patient.setPid(1);
//		patient.setName("akash");
//		patient.setCenterPrefrence("gov");
//		patient.setEmailAddress("9725@gmail.com");
//		patient.setPhoneNumber(123456);
//		patient.setVaccinationPrefrence("covaxin");
//
//
//		Doctor doctor=new Doctor();
//		doctor.setDocDegree("mbbs");
//		doctor.setDocName("sanket");
//		doctor.setPatientCount(23);
//
//		patient.setDoctor(doctor);
//		doctor.setPatient(patient);
//		doctorRepository.save(doctor);
//		//patientRepository.save(patient);
//	}

}
