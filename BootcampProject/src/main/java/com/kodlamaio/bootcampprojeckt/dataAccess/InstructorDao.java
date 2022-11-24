package com.kodlamaio.bootcampprojeckt.dataAccess;

import com.kodlamaio.bootcampprojeckt.entities.concretes.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDao extends JpaRepository<Instructor, Integer> {
    boolean existsByNationalIdentity(String nationalIdentity);
}
