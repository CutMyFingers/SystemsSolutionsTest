package com.solutions.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.dao.EquationDAO;
import com.solutions.dto.EquationDTO;
import com.solutions.model.Equation;
import com.solutions.service.IEquation;

@Service
public class EquationImpl implements IEquation {

    private static final String SOLVED_MESSAGE_TEMPLATE = "Solved equation %.1fx^2 + %.1fx + %.1f = 0. First root = %.2f, second root = %.2f. Discriminant = %.2f.";
    private static final String ERROR_MESSAGE_TEMPLATE = "Error. The equation %.1fx^2 + %.1fx + %.1f = 0 has no roots. Discriminant = %.2f.";
    private final Pattern isDigitPattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Autowired
    private EquationDAO equationDaoImpl;

    @Override
    public List<EquationDTO> findAll() {
        List<EquationDTO> responseData = new ArrayList<>();
        for (Equation e : equationDaoImpl.findAll()) {
            responseData.add(toDTO(e));
        }

        return responseData;
    }

    @Override
    public EquationDTO findById(Integer id) {
        Equation equation = equationDaoImpl.find(id);
        return toDTO(equation);
    }

    @Override
    public String calculate(String aStr, String bStr, String cStr) {
        boolean parametersAreNumbers = isNumeric(aStr) && isNumeric(bStr) && isNumeric(cStr);
        if (!parametersAreNumbers) {
            return "Error. Coefficients are not numbers.";
        }

        String response;
        Double firstRoot;
        Double secondRoot;
        Double a = Double.parseDouble(aStr);
        Double b = Double.parseDouble(bStr);
        Double c = Double.parseDouble(cStr);
        Double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            firstRoot = (-b + Math.sqrt(discriminant)) / (2 * a);
            secondRoot = (-b - Math.sqrt(discriminant)) / (2 * a);
            save(a, b, c, firstRoot, secondRoot, discriminant);

            response = buildResponse(SOLVED_MESSAGE_TEMPLATE, a, b, c, firstRoot, secondRoot, discriminant);
        } else if (discriminant == 0) {
            firstRoot = secondRoot = -b / (2 * a);
            save(a, b, c, firstRoot, secondRoot, discriminant);

            response = buildResponse(SOLVED_MESSAGE_TEMPLATE, a, b, c, firstRoot, secondRoot, discriminant);
        } else {
            response = buildResponse(ERROR_MESSAGE_TEMPLATE, a, b, c, discriminant);
        }

        return response;
    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return isDigitPattern.matcher(strNum)
            .matches();
    }

    private String buildResponse(String template, Object... args) {
        return String.format(template, args);
    }

    private void save(Double a, Double b, Double c, Double firstRoot, Double secondRoot, Double discriminant) {
        Equation entity = new Equation();
        entity.setA(a);
        entity.setB(b);
        entity.setC(c);
        entity.setFirstRoot(firstRoot);
        entity.setSecondRoot(secondRoot);
        entity.setDiscriminant(discriminant);
        equationDaoImpl.save(entity);
    }

    private EquationDTO toDTO(Equation entity) {
        return EquationDTO.builder()
            .id(entity.getId())
            .a(entity.getA())
            .b(entity.getB())
            .c(entity.getC())
            .firstRoot(entity.getFirstRoot())
            .secondRoot(entity.getSecondRoot())
            .build();
    }

}
