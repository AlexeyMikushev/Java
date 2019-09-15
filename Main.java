package log;

import java.util.Scanner;

//import static java.lang.Math.*;


public class Main{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double x;
        int k;
        System.out.print("Input x:  ");
        x = scan.nextDouble();
        System.out.print("Input k:");
        k = scan.nextInt();

        System.out.printf("log: %.3f  Taylor series: %.3f", Math.log(1   - x), TaylorS.logn(x, k));
    }

}
