package ru.mgusev.java1.lesson8;

import javax.swing.*;

public class Display extends JLabel {
    private String operand1 = "0";
    private String operand2 = "";
    private String operation = "";
    private String e = "";
    private boolean isEqually = false;
    private double result;

    public Display(String text) {
        super(text);
        operand1 = text;
    }

    public void setOperand1(String text) {
        if (isEqually) {
            isEqually = false;
            clear();
        }
        if (operand1.length() < 12) {
            if (operand1.equals("0")) {
                operand1 = text;
                setText(operand1);
            } else if (!operand1.equals("0")) {
                operand1 += text;
                setText(operand1);
            }
        }
    }

    public void setDot(String dot) {
        if (isEqually) {
            isEqually = false;
            clear();
        }
        if(!operand1.contains(".")) {
            operand1 += dot;
            setText(operand1);
        }
    }

    public void clear() {
        operation = "";
        operand1 = "0";
        setText(operand1);
    }

    public void setOperation(String text) {
        if (!operand2.equals("")) {
            calculate();
        }
        if (operation.equals("")) {
            operation = text;
            operand2 = operand1;
            operand1 = "0";
            isEqually = false;
            setText(operand2);
        } else {
            operation = text;
        }
    }

    private void zero() {
        if (result % 1 == 0 && result < 2147483647 && result > -2147483648) {
            operand1 = String.valueOf((int)result);
        } else {
            if (result > 2147483647 && String.valueOf(result).length() > 12) {
                operand1 = String.valueOf(result).substring(0, 12);
                e = "E";
            } else operand1 = String.valueOf(result);
        }
        operand2 = "";
        operation = "";
        isEqually = true;
        setText(operand1 + e);
        e = "";
    }

    public void calculate() {
        if (operand1.equals("")) {
            setText(operand2);
        } else if (operation.equals("+")) {
            result = Double.parseDouble(operand2) + Double.parseDouble(operand1);
            zero();
        } else if (operation.equals("-")) {
            result = Double.parseDouble(operand2) - Double.parseDouble(operand1);
            zero();
        } else if (operation.equals("*")) {
            result = Double.parseDouble(operand2) * Double.parseDouble(operand1);
            zero();
        } else if (operation.equals("÷")) {
            if (Double.parseDouble(operand1) != 0.0) {
                result = Double.parseDouble(operand2) / Double.parseDouble(operand1);
                zero();
            } else {
                operation = "";
                operand1 = "0";
                setText("ERROR");
            }
        } else {
            setText(operand1);
        }
    }
}