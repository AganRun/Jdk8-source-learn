package test.ref;

public class WeekRefDemo {

    public static void main(String[] args) {

    }

    class Person {
        String name;
        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{ name='" + name + '}';
        }
    }
}
