package com.kodlamaio.bootcampprojeckt.dataAccess;

import com.kodlamaio.bootcampprojeckt.entities.concretes.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampDao extends JpaRepository<Bootcamp, Integer> {
}
