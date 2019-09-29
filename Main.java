import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        String str = new String();
        Scanner scan = new Scanner(System.in);
        Comparator<String> stringLengthComparator = new StringLengthSort();
        ArrayList<String> arrayList = new ArrayList<>();

        do {
            str = scan.nextLine();
            String [] words = str.split("[.]|[,]|[ ]");

            Arrays.sort(words, stringLengthComparator);

            for (String i : words) {
                arrayList.add(i);
            }
            arrayList.add("\n");
        } while (!str.isEmpty());

        arrayList.forEach((i) -> System.out.print(" "+ i));
    }
}
