import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Student[] students;
    private static int N = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        students = new Student[N];

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            students[i] = new Student(i + 1, Integer.parseInt(line[0]), Integer.parseInt(line[1]));    
        }

        Arrays.sort(students, (a, b) -> {
            if(a.height != b.height){
                return b.height - a.height;
            } else {
                if(a.weight != b.weight){
                    return b.weight - a.weight;
                } else {
                    return a.id - b.id;
                }
            }
        });

        print();
    } 

    private static void print(){
        for(Student student: students){
            System.out.println(student.toString());
        }
    }

    static class Student{
        private int id;
        private int height;
        private int weight;

        public Student(int id, int height, int weight){
            this.id = id;
            this.height = height;
            this.weight = weight;
        }

        public String toString(){
            return height + " " + weight + " " + id;
        }
    }
}