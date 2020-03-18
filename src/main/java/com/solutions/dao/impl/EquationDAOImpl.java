package com.solutions.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solutions.dao.AbstractDAO;
import com.solutions.dao.EquationDAO;
import com.solutions.model.Equation;

@Repository
@Transactional
public class EquationDAOImpl extends AbstractDAO implements EquationDAO {

    @Override
    public List<Equation> findAll() {
        Criteria criteria = getSession().createCriteria(Equation.class);

        @SuppressWarnings("unchecked")
        List<Equation> equations = criteria.list();
        return equations;
    }

    @Override
    public Equation find(Integer id) {
        Criteria criteria = getSession().createCriteria(Equation.class);
        criteria.add(Restrictions.eq("id", id));
        return (Equation) criteria.uniqueResult();
    }

    @Override
    public void save(Equation entity) {
        persist(entity);
    }

}
