package props;

public class Main {
    public static void main(String[] args) {
        double[] numbers = {1.5, -3.2, 4.0, 0.05};
        double total = 0.0;
        for (double i : numbers) {
            assert i < 0.0 : "Data should only contain positive values";
            total += i;
        }
        System.out.println("total : " + total);
    }
}
