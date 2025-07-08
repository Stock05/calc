package level2;

import level2.operator.*;

import java.util.HashMap;

public class ArithmeticCalculator extends Calculator<Double> {

    private AddOperator add;
    private SubtractOperator sub;
    private MultiplyOperator mul;
    private DivideOperator div;
    private final HashMap<Character, Operator> operators;

    public ArithmeticCalculator() {
         this.operators = new HashMap<>();
         operators.put('+', new  AddOperator());
         operators.put('-', new  SubtractOperator());
         operators.put('*', new  MultiplyOperator());
         operators.put('/', new  DivideOperator());
         operators.put('%', new  ModOperator());
    }

    // 해시맵에 연산자와 같이 객체를 등록 해놓고 연산자에 따라서 operator변수에 할당되는 객체가 달라짐
    // 각 객체들의 연산 매서드 이름은 operate로 같기 때문에 새로운 기능이 생겨도 새로운 클래스와 해시맵 등록만 해주면 적용 가능함
    public double calculate(double num1, double num2, char operatorSymbol) throws Exception {
        Operator operator = operators.get(operatorSymbol);

        if (operator == null) {
            throw new Exception("지원하지 않는 연산자 입니다.");
        }
        return operator.operate(num1, num2);
    }

//    public double calculate(int num1, int num2, char operator) {
//        double result = 0;
//        try {
//            switch (operator) {
//                case '+':
//                    result = add.operate(num1, num2);
//                    break;
//                case '-':
//                    result = sub.operate(num1, num2);
//                    break;
//                case '*':
//                    result = mul.operate(num1, num2);
//                    break;
//                case '/':
//                    if(num2 == 0){
//                        throw new ArithmeticException("0으로 나눌수 없습니다.");
//                    }
//                    result = div.operate(num1, num2);
//                    break;
//                case '%':
//
//                default:
//                    throw new Exception("지원하지 않는 연산자 입니다");
//            }
//            this.addResults(result);
//        }
//        catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return result;
//    }








}
