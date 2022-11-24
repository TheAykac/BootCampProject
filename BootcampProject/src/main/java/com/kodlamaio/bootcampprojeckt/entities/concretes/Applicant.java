package com.kodlamaio.bootcampprojeckt.entities.concretes;

import com.kodlamaio.bootcampprojeckt.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicant")
@Entity
public class Applicant extends User {

    @Column(name = "about")
    private String about;


}
