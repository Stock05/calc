package level2;

public class MultiplyOperator implements ArithmeticCalculator.Operator {
    @Override
    public double operate(double num1, double num2) {
        return num1 * num2;
    }
}
