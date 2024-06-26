import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Student[] students;
    private static int N = 5;

    public static void main(String[] args) throws Exception {
        students = new Student[N];

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            students[i] = new Student(line[0], Integer.parseInt(line[1]), Double.parseDouble(line[2]));    
        }

        Arrays.sort(students, (a, b) -> a.name.compareTo(b.name));
        System.out.println("name");
        print();
        System.out.println();
        Arrays.sort(students, (a, b) -> b.height - a.height);
        System.out.println("height");
        print();
    } 

    private static void print(){
        for(Student student: students){
            System.out.println(student.toString());
        }
    }

    static class Student{
        private String name;
        private int height;
        private double weight;

        public Student(String name, int height, double weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        public String toString(){
            return name + " " + height + " " + weight;
        }
    }
}