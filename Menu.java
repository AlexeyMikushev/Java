package menu;

import java.util.Scanner;

public class Menu {

    public static boolean Menu() {

        int choice = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("1 - factorial\n 2 - flip line\n 3 - string substring\n");

        choice = scan.nextInt();

        switch (choice) {

            case 1: {
                System.out.println("Input number: ");
                long fact = scan.nextInt();
                fact = Factorial(fact);
                System.out.printf("\nFactorial of number: %d\n", fact);
                break;
            }
            case 2: {
                System.out.println("Input string: ");
                StringBuffer string = new StringBuffer();
                string.append(scan.next());
                string.reverse();
                System.out.printf("reverse line: %s\n", string);
                break;
            }
            case 3: {
                System.out.println("Input string: ");
                String string = scan.nextLine();
                string = scan.nextLine();
                System.out.println("Input substring: ");
                String substring = scan.nextLine();
                boolean check;
                check = string.regionMatches(0, substring, 0,  999);
                if (check == false) {
                    System.out.printf("no match\n %s %s\n", string, substring);
                }
                else
                    if (check == true) {
                        System.out.print("substring found\n");
                }
                break;
            }
            case 0: {
                return false;

            }
        }
        return true;
    }

    private static long Factorial(long num) {
        long fact = 1;
        for (int i = 2; i <= num; i++) {
            fact = fact * i;
        }
        return fact;
    }


}


