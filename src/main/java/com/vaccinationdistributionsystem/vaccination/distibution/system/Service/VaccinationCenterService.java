package com.vaccinationdistributionsystem.vaccination.distibution.system.Service;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddVaccinationCenterDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.ResponseDTO.CenterNameDoseTypeDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Enums.VaccinationPrefrence;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.VaccinationCenterNotPresent;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccinationCenterService {

    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;

    public void createVaccinationCenter(AddVaccinationCenterDTO vaccinationCenterDTO){
        VaccinationCenter obj=new VaccinationCenter();
        obj.setCenterName(vaccinationCenterDTO.getCenterName());
        obj.setCovaxinDose(vaccinationCenterDTO.getCovaxinDoses());
        obj.setCovishieldDose(vaccinationCenterDTO.getCovishieldDose());
        obj.setSputnikDose(vaccinationCenterDTO.getSputnicDoses());
        obj.setAddress(vaccinationCenterDTO.getAddress());
        obj.setType(vaccinationCenterDTO.getType().name());

        vaccinationCenterRepository.save(obj);
    }

    public List<VaccinationCenter> findByCenterName(String str){
             List<VaccinationCenter> obj= vaccinationCenterRepository.findByCenterName(str);

             if(obj.size()==0){
                 throw new VaccinationCenterNotPresent("Vaccination center with name "+ str+" does not present in database");
             }

             return obj;
    }

    public List<CenterNameDoseTypeDTO> getperticularDoseCountByCenterName(String centerName, VaccinationPrefrence doseType){
        List<CenterNameDoseTypeDTO> dtolist=new ArrayList<>();
        List<VaccinationCenter> list=findByCenterName(centerName);

        for(VaccinationCenter ele: list){
            CenterNameDoseTypeDTO temp=new CenterNameDoseTypeDTO();
            temp.setCenterName(ele.getCenterName());
            temp.setDoseType(doseType);
            if(doseType.equals("Sputnik")){
                temp.setDoseCount(ele.getSputnikDose());
            }
            else if(doseType.equals("Covaxin")){
                temp.setDoseCount(ele.getCovaxinDose());
            }
            else{
                temp.setDoseCount(ele.getCovishieldDose());
            }
            dtolist.add(temp);
        }
        return dtolist;
    }
}
