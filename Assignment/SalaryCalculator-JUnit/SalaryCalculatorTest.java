package com.lpu.SalaryCalculatorProject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculatorTest {
	 SalaryCalculator calculator = new SalaryCalculator();

	    // Normal Salary Calculation
	    @Test
	    public void testNormalSalaryCalculation() {
//	    	sal, bonus,tax
	        double result = calculator.calculateSalary(50000, 5000, 2000);
	        assertEquals(53000, result);
	    }

	    // Zero Bonus Case
	    @Test
	    public void testZeroBonusCase() {
//	    	sal,bonus is 0 and tax
	        double result = calculator.calculateSalary(40000, 0, 2000);
	        assertEquals(38000, result);
	    }

	    // High Tax Case
	    @Test
	    public void testHighTaxCase() {
	        double result = calculator.calculateSalary(30000, 2000, 28000);
	        assertEquals(4000, result);
	    }

	    // Exception – Negative Basic Salary
	    @Test
	    public void testNegativeBasicSalary() {
	        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
	            calculator.calculateSalary(-10000, 1000, 1000);
	        });

	        assertEquals("Basic salary must be positive", ex.getMessage());
	    }

	    // Exception Case – Tax Greater Than Salary
	    @Test
	    public void testTaxGreaterThanSalary() {
	        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
	            calculator.calculateSalary(20000, 1000, 30000);
	        });

	        assertEquals("Tax cannot exceed basic salary", ex.getMessage());
	    }

	    // 6. Boundary Value Case
	    @Test
	    public void testBoundaryValueCase() {
	        double result = calculator.calculateSalary(1, 0, 0);
	        assertEquals(1, result);
	    }
}
