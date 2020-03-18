package com.solutions.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "equations")
public class Equation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double a;
    private Double b;
    private Double c;
    @Column(name = "first_root")
    private Double firstRoot;
    @Column(name = "second_root")
    private Double secondRoot;
    private Double discriminant;
}
