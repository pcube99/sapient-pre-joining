package com.sapient.pjp2.calculator.Controllers;

import com.sapient.pjp2.calculator.DAO.CalculatorDao;
import com.sapient.pjp2.calculator.Models.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CalculatorController {
    @Autowired
    CalculatorDao calculatorDao;

    @Autowired
    Calculator calculator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage() {
        return "home";
    }

    @RequestMapping("/Calculator")
    public String calculate(Calculator calculator) {
        this.calculator = calculator;
        return "home";
    }


    @RequestMapping("/add")
    public String addNumbers(Model model) {
        int ans = 0;
        ans = calculator.getNumber1() + calculator.getNumber2();
        model.addAttribute("additionAnswer", ans);

        calculator.setAns(ans);
        calculator.setOperator("+");
        try {
            calculatorDao.save(calculator);
        } catch (Exception e) {
            return "error";
        }
        return "add";
    }

    @RequestMapping("/subtraction")
    public String subtractNumbers(Model model) {
        int ans = 0;
        ans = calculator.getNumber1() - calculator.getNumber2();
        model.addAttribute("subtractionAnswer", ans);

        calculator.setAns(ans);
        calculator.setOperator("-");
        try {
            calculatorDao.save(calculator);
        } catch (Exception e) {
            return "error";
        }
        return "subtraction";
    }

    @RequestMapping("/multiplication")
    public String multiplyNumbers(Model model) {
        int ans = 0;
        ans = calculator.getNumber1() * calculator.getNumber2();
        model.addAttribute("multiplicationAnswer", ans);

        calculator.setAns(ans);
        calculator.setOperator("*");
        try {
            calculatorDao.save(calculator);
        } catch (Exception e) {
            return "error";
        }
        return "multiply";
    }

    @RequestMapping("/division")
    public String divideNumbers(Model model) {
        int ans = 0;
        try {
        ans = calculator.getNumber1() / calculator.getNumber2();
        model.addAttribute("divisionAnswer", ans);

        calculator.setAns(ans);
        calculator.setOperator("/");
        calculatorDao.save(calculator);
        } catch (Exception e) {
            return "error";
        }
        return "division";
    }

    @RequestMapping("/history")
    public String history(Model model) {
        try {
            String s = "";
            List<Calculator> calculatorList = (List<Calculator>) calculatorDao.findAll();
            for(Calculator temp: calculatorList) {
                s += temp;
                System.out.print(temp);
            }
            model.addAttribute("previousCalculations", calculatorList);

        } catch (Exception e) {
            return "error";
        }
        return "history";
    }

    }
