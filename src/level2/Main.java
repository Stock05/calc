package level2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 갯수가 10개인 배열
        //int[] results = new int[10];
        //int index = 0;
        Calculator calc = new Calculator();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("사칙연산을 하려면 1번 원의 넓이를 구하려면 2번을 눌러주세요");
            String type = sc.nextLine();
            if (type.equals("2")) {
                System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를 결과값을 보려면 inquiry를 입력하세요: ");
                System.out.println("반지름을 입력하세요");
                String radius = sc.nextLine();
                try{
                    if (radius.equals("exit")) {
                        break;
                    } else if (radius.equals("remove")) {
                        if (calc.circleIsEmpty()) {
                            throw new Exception("결과값이 없습니다.");
                        }
                        else {
                            calc.removeOldCircleResults();
                            continue;
                        }
                    }
                    else if (radius.equals("inquiry")) {
                        if (calc.circleIsEmpty()) {
                            throw new Exception("결과값이 없습니다.");
                        }
                        else {
                            calc.showCircleResults();
                            continue;
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                int intRadius = Integer.parseInt(radius);
                double area = calc.calculateCircleArea(intRadius);
                calc.showResults();
                System.out.println(area);



            }
            else if (type.equals("1")) {
                System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를 결과값을 보려면 inquiry를 입력하세요: ");
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String firstValue = sc.nextLine();
                try{
                    if (firstValue.equals("exit")) {
                        break;
                    } else if (firstValue.equals("remove")) {
                        if (calc.isEmpty()) {
                            throw new Exception("결과값이 없습니다.");
                        }
                        else {
                            calc.removeOldResults();
                            continue;
                        }
                    }
                    else if (firstValue.equals("inquiry")) {
                        if (calc.isEmpty()) {
                            throw new Exception("결과값이 없습니다.");
                        }
                        else {
                            calc.showResults();
                            continue;
                        }
                    }
                }
                catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                int firstIntValue = Integer.parseInt(firstValue);

                System.out.print("두 번째 숫자를 입력하세요: ");
                String secondValue = sc.nextLine();
                int secondIntValue = Integer.parseInt(secondValue);

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                calc.calculate(firstIntValue, secondIntValue, operator);

            }
            else {
                System.out.println("잘못 입력하셨습니다");
            }



        }
    }
}
