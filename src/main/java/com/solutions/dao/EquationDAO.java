package com.solutions.dao;

import java.util.List;

import com.solutions.model.Equation;

public interface EquationDAO {

    List<Equation> findAll();

    Equation find(Integer id);

    void save(Equation entity);
}
