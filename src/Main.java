import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 갯수가 10개인 배열
        //int[] results = new int[10];
        //int index = 0;
        ArrayList<Integer> results = new ArrayList<Integer>();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("중지 하시려면 exit를, 가장 오래된 값을 제거하려면 remove를 결과값을 보려면 inquiry를 입력하세요: ");
            System.out.print("첫 번째 숫자를 입력하세요: ");
            String firstValue = sc.nextLine();
            try{
                if (firstValue.equals("exit")) {
                    break;
                } else if (firstValue.equals("remove")) {
                    if (results.isEmpty()) {
                        throw new Exception("결과값이 없습니다.");
                    }
                    else {
                        results.remove(0);
                        continue;
                    }
                }
                else if (firstValue.equals("inquiry")) {
                    if (results.isEmpty()) {
                        throw new Exception("결과값이 없습니다.");
                    }
                    else {
                        results.forEach(data ->System.out.println(data));
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

            int result = 0;
            try {
                switch (operator) {
                    case '+':
                        result = firstIntValue + secondIntValue;
                        break;
                    case '-':
                        result = firstIntValue - secondIntValue;
                        break;
                    case '*':
                        result = firstIntValue * secondIntValue;
                        break;
                    case '/':
                        if(secondIntValue == 0){
                            throw new ArithmeticException("0으로 나눌수 없습니다.");
                        }
                        result = firstIntValue / secondIntValue;
                        break;
                    default:
                        throw new Exception("지원하지 않는 연산자 입니다");
                }
                //배열 사용시 사용
                //results[index % 10] =  result;
                //index++;
                results.add(result);
                System.out.println(result);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }







    }
}
