import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Student[] students;
    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        students = new Student[N];

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            students[i] = new Student(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        }

        Arrays.sort(students, (a, b) -> {
            if(a.korean != b.korean){
                return b.korean - a.korean;
            } else {
                if(a.english != b.english){
                    return b.english - a.english;
                } else {
                    return b.math - a.math;
                }
            }
        });

        for(Student student : students){
            System.out.println(student.toString());
        }
    }

    static class Student{
        private String name;
        private int korean;
        private int english;
        private int math;

        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        public String toString(){
            return name + " " + korean + " " + english + " " + math;
        }
    }
}