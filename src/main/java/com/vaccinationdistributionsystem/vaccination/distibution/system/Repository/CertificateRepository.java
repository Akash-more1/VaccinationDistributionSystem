package com.vaccinationdistributionsystem.vaccination.distibution.system.Repository;

import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Certificates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends JpaRepository<Certificates,Integer> {

    @Query(value = "select * from Certificates where patient_pid=:pid ",nativeQuery = true)
    public List<Certificates> findByPatient(int pid);
}
