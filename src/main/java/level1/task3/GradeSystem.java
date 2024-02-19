package level1.task3;

import java.util.Scanner;

public class GradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total marks of student");
        int sm = sc.nextInt();
        char grade;
        if(sm>=75){
            grade='A';
        }else if (sm>=60){
            grade='B';
        }
        else {
            grade='C';
        }
        System.out.println("Student got :" + grade);
    }
}
