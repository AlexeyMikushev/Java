import java.util.Scanner;

public class Main {
    public static void main(String [] args)
    {
        System.out.print("Input height\n");
        Scanner scan = new Scanner(System.in);
        int height = scan.nextInt();
        System.out.print("\nInput width\n");
        int width = scan.nextInt();
        Matrix matrix = new Matrix(width, height);
        matrix.Output();
        matrix.SwapLines();
        System.out.print("\n New matrix:\n");
        matrix.Output();
        NullLine nullline = matrix.FindNullEl();
        for (int i = 0; i < Math.min(width, height); i++) {
            if (nullline.check[i]) {
                System.out.printf("number of line: %d, max element: %d\n", nullline.numOfLine[i] + 1, nullline.maxEl[i]);
            }
        }

    }
}
