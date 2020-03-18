package com.solutions.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class EquationDTO {

    private Integer id;
    private Double a;
    private Double b;
    private Double c;
    private Double firstRoot;
    private Double secondRoot;
}