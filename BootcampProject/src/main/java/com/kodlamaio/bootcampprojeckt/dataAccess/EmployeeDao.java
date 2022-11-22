package com.kodlamaio.bootcampprojeckt.dataAccess;

import com.kodlamaio.bootcampprojeckt.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
}
