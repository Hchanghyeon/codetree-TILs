import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static int N = 0;
    private static Person[] people;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(bufferedReader.readLine());
        people = new Person[N];

        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            people[i] = new Person(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }

        Arrays.sort(people, (a, b) -> a.height - b.height);
        print();
    }

    private static void print(){
        for(Person person : people){
            System.out.println(person.name + " " + person.height + " " + person.weight);
        }
    }

    static class Person{
        private String name;
        private int height;
        private int weight;

        public Person(String name, int height, int weight){
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }
}