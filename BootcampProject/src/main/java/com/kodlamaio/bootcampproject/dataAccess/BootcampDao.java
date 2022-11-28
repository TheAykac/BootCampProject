package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.concretes.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BootcampDao extends JpaRepository<Bootcamp, Integer> {

}
