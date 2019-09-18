package log;

import java.util.Scanner;




public class Main{

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        double x;

        int k;
        System.out.print("Input x, [-1;1):  ");
        x = scan.nextDouble();

        if (Math.abs(x) > 1)
        {
            System.out.print("Invalid input");
            return;
        }

        System.out.print("Input k: ");
        k = scan.nextInt();

        System.out.printf("log: %.8f  Taylor series: %.8f", Math.log(1   - x), TaylorS.logn(x, k));
    }

}
