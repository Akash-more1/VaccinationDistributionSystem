package com.vaccinationdistributionsystem.vaccination.distibution.system.Repository;

import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


}
