package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.concretes.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ApplicantDao extends JpaRepository<Applicant, Integer> {

    boolean existsByNationalIdentity(String nationalIdentity);

   // @Query(value = "insert into fruits_table (id, about) VALUES (:id, :about)", nativeQuery = true)
    //void employeeAdd (int id , String about);
}
