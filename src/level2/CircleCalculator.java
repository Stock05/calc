package level2;

public class CircleCalculator extends Calculator<Double> {


    public double calculateCircleArea(int radius) {
        double result = Math.PI * radius * radius;
        this.results.add(result);
        return result;
    }
}
