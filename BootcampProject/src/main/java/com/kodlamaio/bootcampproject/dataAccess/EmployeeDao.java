package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    boolean existsByNationalIdentity(String nationalIdentity);

}
