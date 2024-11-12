package com.github.vanchikov.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence_generator")
    @SequenceGenerator(name = "employee_sequence_generator", sequenceName = "employee_sequence", allocationSize = 1)
    private long id;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "firstname")
    private String firstName;
    private String patronymic;
    @Column(name = "birthdate")
    private Date birthDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "positionid")
    private PositionType position;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopid")
    private Shop shop;
    private boolean gender;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "electroemployee",
            joinColumns = {@JoinColumn(name = "employeeid")},
            inverseJoinColumns = {@JoinColumn(name = "electrotypeid")})
    List<ElectroType> electroTypes;
}
