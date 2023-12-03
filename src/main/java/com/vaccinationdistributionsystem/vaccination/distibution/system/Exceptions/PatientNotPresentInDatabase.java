package com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions;

public class PatientNotPresentInDatabase extends  RuntimeException{

    public PatientNotPresentInDatabase(String str){
        super(str);
    }
}
