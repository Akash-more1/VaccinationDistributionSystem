package com.vaccinationdistributionsystem.vaccination.distibution.system.Exceptions;

public class AlreadyVaccinated extends RuntimeException{

    public AlreadyVaccinated(String str){
        super(str);
    }
}
