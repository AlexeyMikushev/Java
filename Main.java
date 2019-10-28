import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        List<Student> students = new ArrayList<Student>();
//        BinIn(students);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:\\Users\\User\\IdeaProjects\\Students\\students.bin"));
        ArrayList<Student> students = (ArrayList<Student>) in.readObject();

        printExcellentStudents(students, new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Students\\excellentStudents.txt"));
        printBadStudents(students, new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Students\\badStudents.txt"));
        sortByName(students, new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Students\\sortByName.txt"));
        sortByName(students, new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Students\\sortByAverageMark.txt"));

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\User\\IdeaProjects\\Students\\students.bin"));
        out.writeObject(students);


    }


    public static void BinIn(List<Student> students) throws IOException {
        students.add(new Student("Первый Второй"));
        students.add(new Student("Третий Четвёртый"));
        students.add(new Student("Пятый Шестой"));
        students.add(new Student("Седьмой Восьмой"));
        students.add(new Student("Девятый Десятый"));
        students.add(new Student("Одиннадцатый Двенадцатый"));
        students.add(new Student("Тринадцатый Четырнадцатый"));
        for (int i = 0; i < students.size(); i++) {

            students.get(i).sessions = new ArrayList<Session>(5);
            for (int j = 0; j < 2; j++) {


                Session session = new Session();
                session.subjects = new HashMap<Subjects, Integer>(5);
                for (Subjects subject : Subjects.values()) {
                    session.subjects.put(subject, 4 + (int) (Math.random() * 1024) % 5);
                    students.get(i).sessions.add(session);
                }

            }
            try{
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("students.bin"));
                out.writeObject(students);

            } catch (IOException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }


    public static void printExcellentStudents(List<Student> students, OutputStream out) throws IOException {
        out.write(("Excellent students: ".getBytes()));

        for (Student i: students) {
            try {

                if (i.averageMark() >= 6) {
                    out.write(i.toString().getBytes());
                }
            }
            catch(IOException e){
                System.out.print(e.getMessage());
            };
        }
    }


    public static void sortByName(List<Student> students, OutputStream out) throws IOException {
        out.write("Sorted by name: ".getBytes());
        students.sort(
                (student1, student2) -> student1.name.compareTo(student2.name)
        );
        for (Student i: students) {
            try {
                out.write(i.toString().getBytes());
            }
            catch(IOException e){
                System.out.print(e.getMessage());
            };
        }
    }



    public static void printBadStudents(List<Student> students, OutputStream out) throws IOException {

        out.write("Bad students: ".getBytes());
        for (Student i: students) {
            try {
                if (i.averageMark() < 6) {
                    out.write(i.toString().getBytes());
                }
            }
            catch(IOException e){
                System.out.print(e.getMessage());
            };
        }

    }

}

