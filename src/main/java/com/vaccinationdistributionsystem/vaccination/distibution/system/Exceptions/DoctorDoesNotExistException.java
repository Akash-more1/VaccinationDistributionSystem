package com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions;

public class DoctorDoesNotExistException extends RuntimeException {

   public DoctorDoesNotExistException(String str){
        super(str);
    }
}
