package com.solutions.service;

import java.util.List;

import com.solutions.dto.EquationDTO;

public interface IEquation {

    String calculate(String a, String b, String c);

    List<EquationDTO> findAll();

    EquationDTO findById(Integer id);
}
