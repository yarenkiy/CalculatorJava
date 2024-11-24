package com.example.project2_;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorModel {
    private BigDecimal leftOperand;
    private BigDecimal rightOperand;
    private String operator;
    private BigDecimal result;

    public CalculatorModel() {
        this.clear();
    }

    public void setLeftOperand(String value) {
        this.leftOperand = new BigDecimal(value);
    }

    public void setRightOperand(String value) {
        this.rightOperand = new BigDecimal(value);
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public BigDecimal getResult() {
        return this.result;
    }

    public void calculate() {
        switch (this.operator) {
            case "+":
                this.result = this.leftOperand.add(this.rightOperand);
                break;
            case "-":
                this.result = this.leftOperand.subtract(this.rightOperand);
                break;
            case "*":
                this.result = this.leftOperand.multiply(this.rightOperand);
                break;
            case "/":
                if (this.rightOperand.compareTo(BigDecimal.ZERO) == 0) {
                    throw new ArithmeticException("Division by zero");
                }

                this.result = this.leftOperand.divide(this.rightOperand, 10, RoundingMode.HALF_UP);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }

    }

    public void clear() {
        this.leftOperand = BigDecimal.ZERO;
        this.rightOperand = BigDecimal.ZERO;
        this.operator = "";
        this.result = BigDecimal.ZERO;
    }
}
