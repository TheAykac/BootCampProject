package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.concretes.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDao extends JpaRepository<Applicant, Integer> {

    boolean existsByNationalIdentity(String nationalIdentity);
}
