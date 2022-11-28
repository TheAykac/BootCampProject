package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.business.responses.applicationResponses.GetApplicationRespose;
import com.kodlamaio.bootcampproject.entities.concretes.Application;
import com.kodlamaio.bootcampproject.entities.concretes.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationDao extends JpaRepository<Application, Integer> {
    List<Application> getApplicationByBootCamp_Id(int bootcampId);

}
