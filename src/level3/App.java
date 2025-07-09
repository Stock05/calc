package level3;

import java.util.Scanner;

public class App {

    ArithmeticCalculator arithmeticCalculator;
    CircleCalculator circleCalculator;
    Scanner sc;

    public App(){
        arithmeticCalculator = new ArithmeticCalculator();
        circleCalculator = new CircleCalculator();
        sc = new Scanner(System.in);
    }

    public boolean sepcilalCommand(Calculator calculator, String input) throws Exception{

        if (input.equals("exit")) {
            return false;
        } else if (input.equals("remove")) {
            if (calculator.isResultEmpty()) {
                throw new Exception("결과값이 없습니다.");
            }
            else {
                calculator.removeOldResults();
                return true;//CONTINUE
            }
        }
        else if (input.equals("inquiry")) {
            if (calculator.isResultEmpty()) {
                throw new Exception("결과값이 없습니다.");
            }
            else {
                calculator.inquiryResults();
                return true; //CONTINUE
            }
        }
        else if (input.equals("greater")) {
            if (calculator.isResultEmpty()) {
                throw new Exception("결과값이 없습니다.");
            }
            else {
                System.out.println("보다 큰 숫자를 확인할 값을 입력하세요");
                String value = sc.nextLine();
                double doubleValue = Double.parseDouble(value);
                arithmeticCalculator.getResultsGreaterThan(doubleValue);
                return true;
            }
        }
        return false;
    }


    public void start(){

        while (true) {
            try{
                System.out.println("사칙연산을 하려면 1번 원의 넓이를 구하려면 2번을 눌러주세요");
                String type = sc.nextLine();

                if (type.equals("2")) {
                    System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를, 결과값을 보려면 inquiry를 입력하세요: ");
                    System.out.println("반지름을 입력하세요");
                    String radius = sc.nextLine();
                    if(sepcilalCommand(circleCalculator, radius)){
                        continue;
                    } else if (false) {
                        break;
                    }

                    double doubleRadius = Double.parseDouble(radius);
                    double area = circleCalculator.calculateCircleArea(doubleRadius);
                    circleCalculator.addResults(area);
                    System.out.println(area);

                }
                else if (type.equals("1")) {
                    System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를, 결과값을 보려면 inquiry를, 보다 큰수를 확인하려면 greater를 입력하세요 ");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    String firstValue = sc.nextLine();
                    if(sepcilalCommand(arithmeticCalculator, firstValue)){
                        continue;
                    }else if (false) {
                        break;
                    }

                    double firstDoubleValue = Double.parseDouble(firstValue);
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    String secondValue = sc.nextLine();
                    double secondDoubleValue = Double.parseDouble(secondValue);
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.nextLine().charAt(0);
                    double result = arithmeticCalculator.calculate(firstDoubleValue, secondDoubleValue, operator);
                    arithmeticCalculator.addResults(result);
                    System.out.println(result);
                }
                else {
                    System.out.println("잘못 입력하셨습니다");
                }

            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

