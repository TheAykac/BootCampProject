package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.concretes.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationDao extends JpaRepository<Application, Integer> {

}
