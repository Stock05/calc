package level2;

import java.util.Scanner;

public class App {
    public void start(){
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();
        CircleCalculator circleCalculator = new CircleCalculator();
        while (true) {
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("사칙연산을 하려면 1번 원의 넓이를 구하려면 2번을 눌러주세요");
                String type = sc.nextLine();
                if (type.equals("2")) {
                    System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를 결과값을 보려면 inquiry를 입력하세요: ");
                    System.out.println("반지름을 입력하세요");
                    String radius = sc.nextLine();

                if (radius.equals("exit")) {
                    break;
                } else if (radius.equals("remove")) {
                    if (circleCalculator.isResultEmpty()) {
                        throw new Exception("결과값이 없습니다.");
                    }
                    else {
                        circleCalculator.removeOldResults();
                        continue;
                    }
                }
                else if (radius.equals("inquiry")) {
                    if (circleCalculator.isResultEmpty()) {
                        throw new Exception("결과값이 없습니다.");
                    }
                    else {
                        circleCalculator.inquiryResults();
                        continue;
                    }
                }
                int intRadius = Integer.parseInt(radius);
                double area = circleCalculator.calculateCircleArea(intRadius);
                System.out.println(area);

                }
                else if (type.equals("1")) {
                    System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를 결과값을 보려면 inquiry를 입력하세요: ");
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    String firstValue = sc.nextLine();

                    if (firstValue.equals("exit")) {
                        break;
                    } else if (firstValue.equals("remove")) {
                        if (arithmeticCalculator.isResultEmpty()) {
                            throw new Exception("결과값이 없습니다.");
                        }
                        else {
                            arithmeticCalculator.removeOldResults();
                            continue;
                        }
                    }
                    else if (firstValue.equals("inquiry")) {
                        if (arithmeticCalculator.isResultEmpty()) {
                            throw new Exception("결과값이 없습니다.");
                        }
                        else {
                            arithmeticCalculator.inquiryResults();
                            continue;
                        }
                    }

                    double firstDoubleValue = Double.parseDouble(firstValue);
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    String secondValue = sc.nextLine();
                    double secondDoubleValue = Double.parseDouble(secondValue);
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    char operator = sc.next().charAt(0);
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
