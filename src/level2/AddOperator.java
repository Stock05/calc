package level2;

public class AddOperator implements ArithmeticCalculator.Operator {

    public AddOperator() {

    }

    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }

}
