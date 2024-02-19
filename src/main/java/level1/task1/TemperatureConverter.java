package level1.task1;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String arg[]) {
        //This variables will use in formulae so i just declare it and not given actual value
        double f, c;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose type of conversion\n 1.Celsius to Fahrenheit\n 2.Fahrenheit to Celsius");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("Enter Celsius temperature");
                c = sc.nextDouble();
                //formulae that give fahrenheit temperature from celsius
                f = ((9 * c) / 5) + 32;
                System.out.println("Fahrenheit temperature is = " + f);
                break;
            case 2:
                System.out.println("Enter Fahrenheit temperature");
                f = sc.nextDouble();
                //formulae that give celsius temperature from fahrenheit
                c = (f - 32) * 5 / 9;
                System.out.println("Celsius temperature is = " + c);
                break;
            default:
                System.out.println("Enter valid temperature");
        }
    }
}
