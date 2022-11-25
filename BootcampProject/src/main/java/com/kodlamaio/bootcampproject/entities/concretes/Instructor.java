package com.kodlamaio.bootcampproject.entities.concretes;

import com.kodlamaio.bootcampproject.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "instructor")
public class Instructor extends User {

    @Column(name = "company_name")
    private String companyName;
}
