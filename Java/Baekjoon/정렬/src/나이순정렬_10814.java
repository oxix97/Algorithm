import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순정렬_10814 {
    static int N;
    static Person[] people;

    static class Person implements Comparable<Person> {
        public int age;
        public String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

//        @Override
//        public int compare(Person p1, Person p2) {
//            return p1.age - p2.age;
//        }

        @Override
        public int compareTo(Person person) {
            return this.age-person.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        people = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people[i] = new Person(age, name);
        }

        Arrays.sort(people);

        for (Person p : people) {
            System.out.println(p.age+" "+p.name);
        }
    }
}
