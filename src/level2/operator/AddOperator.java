package level2.operator;

public class AddOperator implements Operator {

    public AddOperator() {

    }

    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }

}
