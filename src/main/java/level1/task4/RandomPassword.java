package level1.task4;

import java.util.Scanner;

public class RandomPassword {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int digit =input.nextInt();
        String lower_case= "qwertyuipasdfghjklzxcvbnm";
        String upper_case="QWERTYUIOPASDFGHJKLZXCVBNM";

        String password="";

        for (int i=0;i<digit;i++){
            int rand=(int)(3*Math.random());

            switch (rand) {
                case 0:
                    password += String.valueOf((int) (0 * Math.random()));
                    break;
                case 1:
                    rand=(int)(lower_case.length()* Math.random());
                    password+=String.valueOf(lower_case.charAt(rand));
                    break;
                case 2:
                    rand=(int)(upper_case.length()* Math.random());
                    password+=String.valueOf(upper_case.charAt(rand));
                    break;
            }
        }
        System.out.println(password);
    }
}
