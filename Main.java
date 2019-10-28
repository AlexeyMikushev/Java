import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int route[][];
    private static List<Pair<Integer, Integer>>[] vertices;
    private static int endVertex;
    private static int startVertex;
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        startVertex = scan.nextInt();
        endVertex = scan.nextInt();
        int revStartVertex;
        int revEndVertex;
        vertices = (List<Pair<Integer, Integer>>[]) new ArrayList[n];

        route = new int[n][3];

        for (int i = 0; i < n; i++)
            vertices[i] = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < m; i++) {

            int firstVertex = scan.nextInt();
            int secondVertex = scan.nextInt();

            int weight = scan.nextInt();
            if (firstVertex > secondVertex)
                firstVertex = ReturnFirst(secondVertex, secondVertex = firstVertex);
            vertices[firstVertex - 1].add(new Pair(secondVertex, weight));
            vertices[secondVertex - 1].add(new Pair(firstVertex, weight));
        }

        NextStep(startVertex - 1);

        for (int i = 0; i < n; i++)
            if (route[i][2] == 0) {
                System.out.print("A graph is disconnected");
                return;
            }
        System.out.print(route[endVertex - 1][1] + "\n");
        int current = endVertex -1;
        System.out.print(endVertex + " ");

         do {
            System.out.print(route[current][0] + 1 + " ");
            current = route[current][0];
        } while (current != startVertex - 1);
    }

    static int ReturnFirst(int x, int y) {
        return x;
    }

    static void NextStep(int vertex) {
        List<Pair<Integer, Integer>> queue = new ArrayList<Pair<Integer, Integer>>(0);
        for (Pair<Integer, Integer> j : vertices[vertex]) {
            if ((route[j.getKey() - 1][1] > route[vertex][1] + j.getValue() || route[j.getKey() - 1][1] == 0)) {
                route[j.getKey() - 1][0] = vertex;
                route[j.getKey() - 1][1] = route[vertex][1] + j.getValue();
                queue.add(j);
            }
        }
        route[vertex][2] = 1;

        for (Pair<Integer, Integer> j : queue) {
            if (j.getKey() != endVertex)
                NextStep(j.getKey() - 1);
            if (j.getKey() == endVertex)
                route[endVertex - 1][2] = 1;
        }
    }
}