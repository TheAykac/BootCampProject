package com.kodlamaio.bootcampprojeckt.entities.concretes;

import com.kodlamaio.bootcampprojeckt.business.enums.ApplicationState;
import com.kodlamaio.bootcampprojeckt.entities.abstracts.User;
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

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

    @ManyToOne
    private Bootcamp bootCamp;


}
