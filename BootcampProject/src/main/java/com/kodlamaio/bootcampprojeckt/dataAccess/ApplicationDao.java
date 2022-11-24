package com.kodlamaio.bootcampprojeckt.dataAccess;

import com.kodlamaio.bootcampprojeckt.entities.concretes.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDao extends JpaRepository<Application, Integer> {

}
