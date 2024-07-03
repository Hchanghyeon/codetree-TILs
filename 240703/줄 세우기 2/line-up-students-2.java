import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;
    private static Student[] students;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        students = new Student[N];        

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");

            students[i] = new Student(i + 1, Integer.parseInt(line[1]), Integer.parseInt(line[0]));
        }
        
        Arrays.sort(students, (a, b) -> {
            if(a.height != b.height){
                return a.height - b.height;
            } 

            return b.weight - a.weight;
        });

        for(Student student : students){
            System.out.println(student.toString());
        }        
    }

    static class Student {
        private int id;
        private int weight;
        private int height;

        public Student(int id, int weight, int height){
            this.id = id;
            this.weight = weight;
            this.height = height;
        }

        public String toString(){
            return this.height + " " + this.weight + " " + this.id;
        }
    }
}