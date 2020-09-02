package com.sapient.pjp2.incomeAnalysis;

import com.codoid.products.exception.FilloException;
import com.sapient.pjp2.incomeAnalysis.Controllers.IncomeController;
import com.sapient.pjp2.incomeAnalysis.Models.Income;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
@SpringBootTest
class IncomeAnalysisApplicationTests {

	@Autowired
	IncomeController incomeController;

	@Test
	public void testIndiaMale() throws FilloException, IOException {
		List<Income> list = incomeController.findAverage();
 		Income income = list.get(1);
		float res = income.getAvgIncome();
		System.out.println(res);
		Assert.assertEquals(3658.322, res,3);
	}

	@Test
	public void testSGPMale() throws FilloException, IOException {
		Income income = incomeController.findAverage().get(7);
		float res = income.getAvgIncome();
		System.out.println(res);
		Assert.assertEquals(51240.0, res,1);
	}

}
