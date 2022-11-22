package com.kodlamaio.bootcampprojeckt.dataAccess;

import com.kodlamaio.bootcampprojeckt.entities.concretes.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantDao  extends JpaRepository<Applicant,Integer> {
}
