import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static List<Person> people = new ArrayList<>();
    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(bufferedReader.readLine());
        
        for(int i = 0; i < N; i++){
            String[] line = bufferedReader.readLine().split(" ");
            people.add(new Person(line[0], line[1], line[2]));
        }

        List<Person> peopleSortedByName = people.stream().sorted((a, b) -> b.name.compareTo(a.name)).collect(Collectors.toList());

        System.out.println(peopleSortedByName.get(0).print());
    }

    static class Person{
        private String name;
        private String address;
        private String location;

        public Person(String name, String address, String location){
            this.name = name;
            this.address = address;
            this.location = location;
        }

        public String print(){
            return "name " + name + "\n"+"addr " + address + "\n" +"city " + location; 
            
        }
    }
}