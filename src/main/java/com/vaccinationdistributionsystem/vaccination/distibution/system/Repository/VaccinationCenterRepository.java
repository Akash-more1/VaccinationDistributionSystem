package com.vaccinationdistributionsystem.vaccination.distibution.system.Repository;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddVaccinationCenterDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter,Integer> {

    //we have implemented this
    //because of column name from VaccinationCenter Entity
    //this repository will find objects which have same name as given
    //and will add in List and return it
    public List<VaccinationCenter> findByCenterName(String str);

    @Query(value = "select vc.vcid, count(*) as count   from vaccination_center  vc   left join patient pt on vc.vcid=pt.vaccination_center_vcid where vc.type= :type group by vc.vcid order by count asc;",nativeQuery = true)
  public List<Object[]> miniPatienCenterByCenterPrefrence (String type);

}
