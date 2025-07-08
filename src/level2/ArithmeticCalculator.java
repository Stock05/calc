package level2;

public class ArithmeticCalculator extends Calculator<Double> {

    private AddOperator add;
    private SubtractOperator sub;
    private MultiplyOperator mul;
    private DivideOperator div;

    public ArithmeticCalculator() {
         add = new AddOperator();
         sub = new SubtractOperator();
         mul = new MultiplyOperator();
         div = new DivideOperator();
    }

    public double calculate(int num1, int num2, char operator) {
        double result = 0;
        try {
            switch (operator) {
                case '+':
                    result = add.operate(num1, num2);
                    break;
                case '-':
                    result = sub.operate(num1, num2);
                    break;
                case '*':
                    result = mul.operate(num1, num2);
                    break;
                case '/':
                    if(num2 == 0){
                        throw new ArithmeticException("0으로 나눌수 없습니다.");
                    }
                    result = div.operate(num1, num2);
                    break;
                case '%':

                default:
                    throw new Exception("지원하지 않는 연산자 입니다");
            }
            this.addResults(result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public interface Operator{
        double operate(double num1, double num2);
    }






}
