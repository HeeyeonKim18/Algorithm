package javaBook.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class Ex14_5 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("김지수", 4, 50),
                new Student("이지수", 3, 100),
                new Student("박지수", 1, 80),
                new Student("이지수", 2, 70),
                new Student("최지수", 4, 60),
                new Student("하지수", 2, 95),
                new Student("정지수", 3, 88)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Student::getGetTotalScore)
                .thenComparing(Student::getName))
                .forEach(System.out::println);
    }
    static class Student{
        String name;
        int ban;
        int getTotalScore;

        public Student(String name, int ban, int getTotalScore) {
            this.name = name;
            this.ban = ban;
            this.getTotalScore = getTotalScore;
        }

        public String getName() {
            return name;
        }

        public int getBan() {
            return ban;
        }

        public int getGetTotalScore() {
            return getTotalScore;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", ban=" + ban +
                    ", getTotalScore=" + getTotalScore +
                    '}';
        }
    }
}
