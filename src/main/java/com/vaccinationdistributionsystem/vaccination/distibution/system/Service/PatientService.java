package com.vaccinationdistributionsystem.vaccination.distibution.system.Service;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddPatientDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Certificates;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Doctor;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Patient;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.AlreadyVaccinated;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.DoctorDoesNotExistException;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.PatientNotPresentInDatabase;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.VaccinationCenterNotPresent;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.CertificateRepository;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.DoctorRepository;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.PatientRepository;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CertificateRepository certificateRepository;

    public Patient findByPatientId(int pid){



            Patient p=patientRepository.findById(pid).orElse(null);

            if(p==null){
                throw new PatientNotPresentInDatabase("Patient with ID "+pid+" you looking is not in database");
            }
            return p;

    }

    public Patient addPatient(AddPatientDTO obj){
        Patient patient=new Patient();

        patient.setName(obj.getName());
        patient.setEmailAddress(obj.getEmail());
        patient.setPhoneNumber(obj.getPhoneNumber());
        patient.setVaccinationPrefrence(obj.getVaccinationPrefrence().toString());
        patient.setCenterPrefrence(obj.getCenterPrefrence().toString());

        List<Object[]> temp1=doctorRepository.minPatientCountDoctorinCenter();

        if(temp1.size()==0){
            throw new DoctorDoesNotExistException("doctor is not present in database");
        }
//        Object[] mindoc=temp1.get(0);
        int minDocId=Integer.parseInt(temp1.get(0)[0].toString());

        Doctor doc=doctorRepository.findById(minDocId).orElse(null);

        patient.setDoctor(doc);


        List<Object[]> temp=vaccinationCenterRepository.miniPatienCenterByCenterPrefrence(obj.getCenterPrefrence().toString());

        if(temp.size()==0){
            throw new VaccinationCenterNotPresent("vaccination center is not present in database");
        }
        //Object[] minarr=temp.get(0);
        int minId=Integer.parseInt(temp.get(0)[0].toString());

        VaccinationCenter vc=vaccinationCenterRepository.findById(minId).orElse(null);

        patient.setVaccinationCenter(vc);




            patientRepository.save(patient);

            return patient;

    }


      public void giveDoseToPatient(int pid){

        Patient patient=patientRepository.findById(pid).orElse(null);

        if(patient==null){
            throw  new PatientNotPresentInDatabase("patient with id "+pid+" not present in database");
        }

        if(certificateRepository.findByPatient(pid).size()!=0){
            throw new AlreadyVaccinated("patient already have vaccination certificate");
        }

        String email=patient.getEmailAddress();

          String docname=patient.getDoctor().getDocName();



          Certificates certificates=new Certificates();
          certificates.setPatient(patient);

          certificateRepository.save(certificates);

          String text="hey "+patient.getName()+"\n "+"Congrats!! you got vaccinated by doctor "+ docname+" and your certificate ID is "+certificates.getCid();

          SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

          simpleMailMessage.setFrom("akashvaccinationcenter@gmail.com");

          simpleMailMessage.setTo(patient.getEmailAddress());

          simpleMailMessage.setSubject("Congrats to got vaccinted");

          simpleMailMessage.setText(text);

          try{
              javaMailSender.send(simpleMailMessage);
          }
          catch (Exception e){
              throw  e;
          }


      }

//    public void addPatient(AddPatientDTO obj) {
//        Patient patient=new Patient();
//
//        patient.setName(obj.getName());
//        patient.setEmailAddress(obj.getEmail());
//        patient.setPhoneNumber(obj.getPhoneNumber());
//        patient.setVaccinationPrefrence(obj.getVaccinationPrefrence().toString());
//        patient.setCenterPrefrence(obj.getCenterPrefrence().toString());
//
//        VaccinationCenter vc=vaccinationCenterRepository.findById(1).orElse(null);
//        patient.setVaccinationCenter(vc);
//
//        Doctor doc=doctorRepository.findById(2).orElse(null);
//        patient.setDoctor(doc);
//
//        patientRepository.save(patient);
//    }
}
