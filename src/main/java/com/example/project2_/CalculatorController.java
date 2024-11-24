package com.example.project2_;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculatorController {
    @FXML
    TextField display;
    CalculatorModel model = new CalculatorModel();
     boolean startNewInput = true;
    String currentInput = "";

    public CalculatorController() {
    }

    @FXML
    public void initialize() {
        this.display.setOnKeyTyped((event) -> {
            String character = event.getCharacter();
            if (character.matches("[0-9]")) {
                this.handleDigit(character);
            } else if (character.matches("[+\\-*/]")) {
                this.handleOperator(character);
            } else if (character.equals("\r")) {
                this.handleEquals();
            } else if (character.equals(".")) {
                this.handleDecimal();
            }

        });
    }

    void handleDigit(String digit) {
        if (this.startNewInput) {
            this.display.setText(digit);
            this.startNewInput = false;
        } else {
            TextField var10000 = this.display;
            String var10001 = this.display.getText();
            var10000.setText(var10001 + digit);
        }

        this.currentInput = this.currentInput + digit;
    }

    @FXML
    void handleOperator(String operator) {
        if (!this.currentInput.isEmpty()) {
            this.model.setLeftOperand(this.currentInput);
            this.model.setOperator(operator);
            TextField var10000 = this.display;
            String var10001 = this.display.getText();
            var10000.setText(var10001 + operator);
            this.startNewInput = true;
            this.currentInput = "";
        }

    }

    @FXML
    void handleEquals() {
        if (!this.currentInput.isEmpty()) {
            this.model.setRightOperand(this.currentInput);

            try {
                this.model.calculate();

                // Round the result to 2 decimal places before displaying
                BigDecimal result = this.model.getResult().setScale(2, RoundingMode.HALF_UP);

                this.display.setText(result.toPlainString());
                this.currentInput = result.toPlainString();
                this.startNewInput = true;
            } catch (ArithmeticException var2) {
                this.display.setText("Error: " + var2.getMessage());
                this.currentInput = "";
                this.startNewInput = true;
            }
        }
    }


    @FXML
    void handleDecimal() {
        if (!this.currentInput.contains(".")) {
            if (this.startNewInput) {
                this.display.setText("0.");
                this.currentInput = "0.";
                this.startNewInput = false;
            } else {
                this.display.setText(this.display.getText() + ".");
                this.currentInput = this.currentInput + ".";
            }
        }

    }

    @FXML
    void handleClear() {
        this.model.clear();
        this.display.setText("");
        this.currentInput = "";
        this.startNewInput = true;
    }

    @FXML
    void handleNegate() {
        if (!this.currentInput.isEmpty()) {
            if (this.currentInput.startsWith("-")) {
                this.currentInput = this.currentInput.substring(1);
            } else {
                this.currentInput = "-" + this.currentInput;
            }

            this.display.setText(this.currentInput);
        }

    }

    @FXML
    private void handleDigit(ActionEvent event) {
        Button button = (Button)event.getSource();
        this.handleDigit(button.getText());
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        Button button = (Button)event.getSource();
        this.handleOperator(button.getText());
    }
}
