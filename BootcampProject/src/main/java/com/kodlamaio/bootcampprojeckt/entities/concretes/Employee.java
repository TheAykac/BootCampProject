package com.kodlamaio.bootcampprojeckt.entities.concretes;

import com.kodlamaio.bootcampprojeckt.entities.abstracts.User;
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
@Table(name = "employee")
public class Employee extends User {

    @Column(name = "positions")
    private String position;
}
