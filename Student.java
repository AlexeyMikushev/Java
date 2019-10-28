import javafx.util.Pair;

import java.io.Serializable;
import java.util.List;

public class Student implements Comparable<Student>, Serializable {
    private static  int amountOfStudent;

    public String name;
    public int id;
    public List<Session> sessions;

    public Student(String name) {
        this.name = name;
        this.id = amountOfStudent++;

    }


    @Override
    public int compareTo(Student otherStudent) {
        if (name.compareTo(otherStudent.name) == 0) {
            return id - otherStudent.id;
        } else return name.compareTo(otherStudent.name);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n" + name).append(" " + id).append(" "+ this.averageMark());
        return result.toString();
    }

    public double averageMark() {
        double sum = 0;
        int numberOfMarks = 0;
        for (Session session : sessions) {
            Pair<Integer, Integer> statistics = session.getStatistics();
            sum += statistics.getKey();
            numberOfMarks += statistics.getValue();
        }
        return (double) sum / numberOfMarks;
    }





}

