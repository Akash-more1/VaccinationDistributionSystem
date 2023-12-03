package com.vaccinationdistributionsystem.vaccination.distibution.system.Repository;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddDoctorDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.ResponseDTO.CenterNameVsDoctorCountDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {

    @Query(value = "select vc.vcid,count(*) as count from vaccination_center  vc   left join doctor doc on vc.vcid=doc.vaccination_center_vcid group by vc.vcid order by count asc limit 1  ;",nativeQuery = true)
    public List<Object[]> findMinDoctorCountVaccinationCenter();

    @Query(value = "select doc.docid, count(*) as count from doctor doc left join patient pt on doc.docid=pt.doctor_docid group by doc.docid order by count asc;",nativeQuery = true)
    public List<Object[]> minPatientCountDoctorinCenter();
}
