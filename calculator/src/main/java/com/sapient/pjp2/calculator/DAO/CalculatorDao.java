package com.sapient.pjp2.calculator.DAO;

import com.sapient.pjp2.calculator.Models.Calculator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculatorDao extends CrudRepository<Calculator, Integer> {
}
