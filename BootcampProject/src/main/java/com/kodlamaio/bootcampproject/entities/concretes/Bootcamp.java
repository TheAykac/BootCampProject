package com.kodlamaio.bootcampproject.entities.concretes;

import com.kodlamaio.bootcampproject.business.enums.BootcampState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bootcamps")
public class Bootcamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "start_date")

    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    private BootcampState bootcampState;

    @ManyToOne
    private Instructor instructor;




}
