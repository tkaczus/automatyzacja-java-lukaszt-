/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class Calculator {

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double divide(double x, double y) {
        return x / y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static void main(String[] args) {
        System.out.println(add(1,2));
        System.out.println(subtract(3,2));
        System.out.println(divide(3,2));
        System.out.println(multiply(1,2));
    }


}
