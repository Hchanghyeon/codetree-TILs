import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Student[] students;
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        
        N = Integer.parseInt(bufferedReader.readLine());
        students = new Student[N];

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            students[i] = new Student(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }
       
       Arrays.sort(students);

       print();
    }

    private static void print(){
        for(Student student : students){
            System.out.println(student.toString());
        }
    }

       static class Student implements Comparable<Student> {
        private String name;
        private int height;
        private int weight;

        public Student(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Student other){
            if(this.height != other.height){
                return this.height - other.height;
            } else {
                return other.weight - this.weight;
            }
        }

        @Override
        public String toString(){
            return name + " " + height + " " + weight;
        }
    }
}