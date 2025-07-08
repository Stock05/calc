package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Calculator {
    ArrayList<Integer> results;
    ArrayList<Double> circleResults;
    // 파이 값을 선언해서 사용한다면 static, final을 사용할수 있다. (불변하는 상수값이기 때문) ex) static final double pi = 3.141592

    public Calculator() {
        results = new ArrayList<Integer>();
        circleResults = new ArrayList<Double>();
    }

    public void calc(){
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를 결과값을 보려면 inquiry를 입력하세요: ");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String firstValue = sc.nextLine();
            try{
                if (firstValue.equals("exit")) {
                    break;
                } else if (firstValue.equals("remove")) {
                    if (this.isEmpty()) {
                        throw new Exception("결과값이 없습니다.");
                    }
                    else {
                        this.removeOldResults();
                        continue;
                    }
                }
                else if (firstValue.equals("inquiry")) {
                    if (this.isEmpty()) {
                        throw new Exception("결과값이 없습니다.");
                    }
                    else {
                        this.showResults();
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

            this.calculate(firstIntValue, secondIntValue, operator);
        }
    }

    public boolean isEmpty() {
        return results.isEmpty();
    }

    public void addResults(int value) {
        this.results.add(value);}

    public void removeOldResults() {
        this.results.remove(0);
    }

    public void showResults() {
        this.results.forEach(System.out::println);
    }

    // 읽기전용 리스트를 받아와서 값이 변하더라도 원본 results는 변하지 않음
    public List<Integer> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    public boolean circleIsEmpty() {
        return this.circleResults.isEmpty();
    }

    public void addCircleResults(double value) {
        this.circleResults.add(value);
    }

    public void removeOldCircleResults() {
        this.circleResults.remove(0);
    }

    public void showCircleResults() {
        this.circleResults.forEach(System.out::println);
    }

    public void calculate(int num1, int num2, char operator) {
        int result = 0;
        try {
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if(num2 == 0){
                        throw new ArithmeticException("0으로 나눌수 없습니다.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new Exception("지원하지 않는 연산자 입니다");
            }
            this.addResults(result);
            System.out.println(result);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public double calculateCircleArea(int radius) {
        double result = Math.PI * radius * radius;
        this.circleResults.add(result);
        return result;
    }




}
