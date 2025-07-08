package level2.operator;

import level2.ArithmeticCalculator;

public class ModOperator implements Operator {


    @Override
    public double operate(double num1, double num2) {
        return num1 % num2;
    }
}
