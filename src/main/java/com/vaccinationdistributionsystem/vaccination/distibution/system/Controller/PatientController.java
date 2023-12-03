package com.vaccinationdistributionsystem.vaccination.distibution.system.Controller;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddPatientDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Patient;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.AlreadyVaccinated;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.DoctorDoesNotExistException;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.PatientNotPresentInDatabase;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.VaccinationCenterNotPresent;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.DoctorRepository;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Service.DoctorService;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/patient/findPatient/{pid}")
    public ResponseEntity findByPatientId (@PathVariable int pid){
      try  {
            Patient p = patientService.findByPatientId(pid);
            return new ResponseEntity(p,HttpStatus.FOUND);
        }
      catch (PatientNotPresentInDatabase e){
          return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
      }
    }

    @PostMapping("/api/patient/addPatient")
    public ResponseEntity addPatient (@RequestBody AddPatientDTO addPatientDTO){


       try {
            Patient obj = patientService.addPatient(addPatientDTO);

            return new ResponseEntity(obj, HttpStatus.CREATED);
        }
       catch (DoctorDoesNotExistException e){
           return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
       }
       catch (VaccinationCenterNotPresent e){
           return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/api/patient/givedose")
    public ResponseEntity giveDose(@RequestParam int pid){

        try{
            patientService.giveDoseToPatient( pid);
            return new ResponseEntity("patient "+pid+" got vaccinated", HttpStatus.OK);
        }
        catch (AlreadyVaccinated e){
               return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
        catch (PatientNotPresentInDatabase e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }


    }
}
