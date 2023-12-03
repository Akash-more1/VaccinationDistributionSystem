package com.vaccinationdistributionsystem.vaccination.distibution.system.Controller;

import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.AddVaccinationCenterDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.DTO.ResponseDTO.CenterNameDoseTypeDTO;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Entity.VaccinationCenter;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Enums.VaccinationPrefrence;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions.VaccinationCenterNotPresent;
import com.vaccinationdistributionsystem.vaccination.distibution.system.Service.VaccinationCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VaccinationCenterController {

    @Autowired
    VaccinationCenterService vaccinationCenterService;

    @PostMapping("/api/vaccinationcenter/add")
    public String createVaccinationCenter(@RequestBody AddVaccinationCenterDTO obj){
        vaccinationCenterService.createVaccinationCenter(obj);
        return "Vaccination center "+obj.getCenterName()+" get created";
    }

    @GetMapping("/api/vaccinationcenter/getByName")
    public ResponseEntity findByCenterName(@RequestParam String str){

        try{
            List<VaccinationCenter> list= vaccinationCenterService.findByCenterName(str);

            return new ResponseEntity(list,HttpStatus.FOUND);
        }
        catch (VaccinationCenterNotPresent e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/api/vaccinationcenter/getByNameDoseAndDoseCount/{centerName}")
    public List<CenterNameDoseTypeDTO> getDoseCountByCenterName(@PathVariable String centerName,@RequestParam VaccinationPrefrence doseType){
        return vaccinationCenterService.getperticularDoseCountByCenterName(centerName,doseType);
    }
}
