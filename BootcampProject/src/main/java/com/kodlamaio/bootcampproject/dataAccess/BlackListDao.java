package com.kodlamaio.bootcampproject.dataAccess;

import com.kodlamaio.bootcampproject.entities.concretes.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListDao extends JpaRepository<BlackList, Integer> {

    boolean existsByApplicantId(int id);
}
