package com.cgi.dentistapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.cgi.dentistapp.dto.DentistVisitDTO;
import com.cgi.dentistapp.entity.DentistVisitEntity;
import com.cgi.dentistapp.repository.DentistVisitRepository;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@EnableAutoConfiguration
public class DentistVisitService {
	
	@Autowired
	private DentistVisitRepository dentistVisitRepository;
	
	

    public void addVisit(DentistVisitEntity dentistVisitEntity) {
    	dentistVisitRepository.save(dentistVisitEntity);
    };
    
    public List<DentistVisitEntity> getList() {
    	return dentistVisitRepository.list();
    };
    
    
    public void deleteVisit(Long id) {
    	dentistVisitRepository.delete(id);
    }
    
    public void getVisit(Long id) {
    	dentistVisitRepository.getOne(id);
    }
    
    public void updateVisit(Long id, String newName, String newDate, String newTime) {
    	DentistVisitEntity updatedEntity = new DentistVisitEntity();
    	updatedEntity.setDentistName(newName);
    	updatedEntity.setId(id);
    	updatedEntity.setVisitDay(newDate);
    	updatedEntity.setVisitTime(newTime);
    	dentistVisitRepository.save(updatedEntity);
    }
    
    public List<DentistVisitEntity> getAllTimesByDate(String date) {
    	return dentistVisitRepository.getAllTimesByDate(date);
    }
    
    
}
