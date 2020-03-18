package com.solutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.solutions.dto.EquationDTO;
import com.solutions.service.IEquation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@EnableWebMvc
public class EquationController {

    @Autowired
    private IEquation equationImpl;

    // Redirects to the home page.
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView model = new ModelAndView();
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public @ResponseBody String calculate(@RequestParam(value = "first_coeff") String a,
            @RequestParam(value = "second_coeff") String b, @RequestParam(value = "third_coeff") String c) {
        log.debug("Solves an equation with coefficients: {}, {}, {}", a, b, c);
        return equationImpl.calculate(a, b, c);
    }

    @RequestMapping(value = "/equation", method = RequestMethod.GET)
    public @ResponseBody EquationDTO find(@RequestParam Integer id) {
        log.debug("Finds an equation result with id = {}", id);
        return equationImpl.findById(id);
    }

    @RequestMapping(value = "/equations", method = RequestMethod.GET)
    public @ResponseBody List<EquationDTO> find() {
        log.debug("Finds all the results of an equation.");
        return equationImpl.findAll();
    }
}