package com.example.project2_;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

public class CalculatorModelTest {
    private CalculatorModel calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorModel();
    }

    @Test
    void testAddition() {
        calculator.setLeftOperand("2");
        calculator.setOperator("+");
        calculator.setRightOperand("3");
        calculator.calculate();
        assertEquals(new BigDecimal("5"), calculator.getResult(), "5");
    }

    @Test
    void testSubtraction() {
        calculator.setLeftOperand("9");
        calculator.setOperator("-");
        calculator.setRightOperand("4");
        calculator.calculate();
        assertEquals(new BigDecimal("5"), calculator.getResult(), " 5");
    }

    @Test
    void testMultiplication() {
        calculator.setLeftOperand("6");
        calculator.setOperator("*");
        calculator.setRightOperand("7");
        calculator.calculate();
        assertEquals(new BigDecimal("42"), calculator.getResult(), " 42");
    }

    @Test
    void testDivision() {
        calculator.setLeftOperand("8");
        calculator.setOperator("/");
        calculator.setRightOperand("2");
        calculator.calculate();
        assertEquals(0, calculator.getResult().compareTo(new BigDecimal("4")), " 4");
    }

    @Test
    void testDivisionByZero() {
        calculator.setLeftOperand("8");
        calculator.setOperator("/");
        calculator.setRightOperand("0");
        Exception exception = assertThrows(ArithmeticException.class, calculator::calculate, "Division by zero should throw ArithmeticException");
        assertEquals("Division by zero", exception.getMessage());
    }
    @Test
    void testPreciseDivision() {
        calculator.setLeftOperand("1");
        calculator.setOperator("/");
        calculator.setRightOperand("3");
        calculator.calculate();
        assertEquals(new BigDecimal("0.3333333333"), calculator.getResult(),
                " 0.3333333333");
    }

    @Test
    void testFloatingPointAddition() {
        calculator.setLeftOperand("3.14");
        calculator.setOperator("+");
        calculator.setRightOperand("2.86");
        calculator.calculate();
        assertEquals(new BigDecimal("6.00"), calculator.getResult(),
                " 6");
    }

    @Test
    void testFloatingPointMultiplication() {
        calculator.setLeftOperand("2.5");
        calculator.setOperator("*");
        calculator.setRightOperand("3.2");
        calculator.calculate();
        assertEquals(new BigDecimal("8.00"), calculator.getResult(),
                "8");
    }

    @Test
    void testNegativeNumbers() {
        calculator.setLeftOperand("-5");
        calculator.setOperator("+");
        calculator.setRightOperand("-3");
        calculator.calculate();
        assertEquals(new BigDecimal("-8"), calculator.getResult(),
                "-8");
    }

    @Test
    void testComplexFloatingPoint() {
        calculator.setLeftOperand("1.23456789");
        calculator.setOperator("*");
        calculator.setRightOperand("9.87654321");
        calculator.calculate();
        assertEquals(new BigDecimal("12.1932631112635269"), calculator.getResult(),
                "12.1932631112635269");
    }

    @Test
    void testLongDivision() {
        calculator.setLeftOperand("10");
        calculator.setOperator("/");
        calculator.setRightOperand("3");
        calculator.calculate();
        assertEquals(new BigDecimal("3.3333333333"), calculator.getResult(),
                "3.3333333333");
    }
}