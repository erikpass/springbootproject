package com.cgi.dentistapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Date;

public class DentistVisitDTO {

    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date visitTime;

    public DentistVisitDTO() {
    }

    public DentistVisitDTO(String dentistName, Date visitTime) {
        this.dentistName = dentistName;
        this.visitTime = visitTime;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
    	System.out.println("dentistName");
    	System.out.println(dentistName);
        this.dentistName = dentistName;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
    	System.out.println("visitTime:");
    	System.out.println(visitTime);
        this.visitTime = visitTime;
    }
}
