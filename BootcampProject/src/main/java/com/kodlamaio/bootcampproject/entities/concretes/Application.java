package com.kodlamaio.bootcampproject.entities.concretes;

import com.kodlamaio.bootcampproject.business.enums.ApplicationState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "applicantions")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    @ManyToOne
    private Bootcamp bootCamp;

    @ManyToOne
    private Applicant applicant;

}
