package level3;

import java.util.ArrayList;

public abstract class Calculator<T> {
    ArrayList<T> results;
    // 파이 값을 선언해서 사용한다면 static, final을 사용할수 있다. (불변하는 상수값이기 때문) ex) static final double pi = 3.141592

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public boolean isResultEmpty() {
        return results.isEmpty();
    }

    public void addResults(T value) {
        this.results.add(value);}

    public void removeOldResults() {
        this.results.remove(0);
    }

    public void inquiryResults() {
        this.results.forEach(System.out::println);
    }









}
