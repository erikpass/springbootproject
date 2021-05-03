package com.cgi.dentistapp.repository;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cgi.dentistapp.entity.DentistVisitEntity;

@Repository
public interface DentistVisitRepository extends JpaRepository<DentistVisitEntity, Long> {
	
	@Modifying
	@Query(value = "insert into dentist_visit (dentistName, visitTime) values (:dentistName, :visitTime)", nativeQuery = true)
	void addDentistVisit(@Param("dentistName") String dentistName, @Param("visitTime") Date visitTime);
	
	@Query("SELECT v FROM DentistVisitEntity v")
	List<DentistVisitEntity> list();

	@Query("SELECT t FROM DentistVisitEntity t WHERE t.visitDay = ?1")
	List<DentistVisitEntity> getAllTimesByDate(String date);

	
}
