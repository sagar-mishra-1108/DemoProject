package com.practice.stream;

import javax.sound.midi.Soundbank;
import javax.swing.text.html.Option;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String ...args) {
        Stream<Integer> intStream1 = Stream.of(10, 40, -5, 15, 33, -17);
//        Integer[] intArray1 = intStream1.toArray(Integer[]::new);
        long count1 = intStream1.count();
        System.out.println(count1);

        IntStream intStream2 = IntStream.of(10, 40, -5, 15, 33);
//        int[] intArray2 = intStream2.toArray();
        long count2 = intStream2.count();
        System.out.println(count2);

        IntStream rangeStream1 = IntStream.range(1, 10);
        IntStream rangeStream2 = IntStream.rangeClosed(1, 10);

        Integer[] array = {10, 40, -5, 15, 33, -17};
        Stream<Integer> intStream3 = Arrays.stream(array);

        List<Integer> list = Arrays.asList(array);
        Stream<Integer> intStream4 = list.stream();


        Student student1 = new Student(1001, "Mark", 500, "Physics");
        Student student2 = new Student(1002, "Tony", 580, "Maths");
        Student student3 = new Student(1003, "Aryan", 670, "Computer");
        Student student4 = new Student(1004, "Xavier", 380, "Computer");
        Student student5 = new Student(1005, "Mary", 580, "Physics");

        Stream<Student> studentStream1 = Stream.of(student1, student2, student3, student4);
        Optional<Student> topScorerStudent = studentStream1.max(Comparator.comparing(Student::getMarks));
        if (topScorerStudent.isPresent()) {
            Student st1 = topScorerStudent.get();
            System.out.println(st1);
        }
        topScorerStudent.ifPresent(System.out::println);

        Stream<Student> studentStream2 = Stream.of(student1, student2, student3, student4);
        Optional<Student> frontStudent = studentStream2.min(Comparator.comparing(Student::getId));
        if (frontStudent.isPresent()) {
            Student st1 = frontStudent.get();
            System.out.println(st1);
        }
        frontStudent.ifPresent(System.out::println);

        String val1 = Optional.of("A String").orElse(print("orElse"));
        String val2 = Optional.of("Another String").orElseGet(() -> print("orElseGet"));
        Object val3 = Optional.empty().orElseGet(() -> print("Nothing"));

        OptionalDouble average1 = Arrays.stream(new int[] {1, 5, 8, 9, 19}).average();
        if (average1.isPresent()) {
            System.out.println(average1.getAsDouble());
        }

        OptionalDouble average2 = Arrays.stream(new int[] {1, 5, 8, 9, 19}).average();
        average2.ifPresent(System.out::println);

        Stream<Student> studentStream3 = Stream.of(student1, student2, student3, student4);
        double totalMarks1 = studentStream3.reduce(0.0, (marks, student) -> marks + student.getMarks(), Double::sum);
        System.out.println(totalMarks1);

        Stream<Student> studentStream4 = Stream.of(student1, student2, student3, student4);
        double totalMarks2 = studentStream4.mapToDouble(Student::getMarks).sum();
        System.out.println(totalMarks2);

        Stream<Student> studentStream5 = Stream.of(student1, student2, student3, student4);
        Optional<Student> firstStudent = studentStream5.findFirst();
        firstStudent.ifPresent(System.out::println);

        Stream<Student> studentStream6 = Stream.of(student1, student2, student3, student4);
        Optional<Student> anyStudent = studentStream6.findAny();
        anyStudent.ifPresent(System.out::println);

        Stream<Student> studentStream7 = Stream.of(student1, student2, student3, student4);
        studentStream7.forEach(System.out::println);

        Stream<Integer> intStream5 = Stream.of(10, 40, -5, 15, 33, -17);
        boolean isAtleastOneEven = intStream5.anyMatch(num -> num % 2 == 0);
        System.out.println(isAtleastOneEven);

        Stream<Integer> intStream6 = Stream.of(10, 40, -5, 15, 33, -17);
        boolean areAllEven = intStream6.allMatch(num -> num % 2 == 0);
        System.out.println(areAllEven);

        Stream<Integer> intStream7 = Stream.of(10, 40, -5, 15, 33, -17);
        boolean areAllLessThan50 = intStream7.noneMatch(num -> num > 50);
        System.out.println(areAllLessThan50);

        Stream<Student> studentStream8 = Stream.of(student1, student2, student3, student4, student5); // 5
        long countAfterSkipFirst2 = studentStream8.skip(2).count();
        System.out.println(countAfterSkipFirst2); // 3

        Stream<Student> studentStream9 = Stream.of(student1, student2, student3, student4, student5); // 5
        long countAfterLimit3 = studentStream9.limit(2).count();
        System.out.println(countAfterLimit3); // 2

        List<Double> randomNumbers = Stream.generate(Math::random)
                .limit(7)
                .map(n -> n*57)
                .collect(Collectors.toList());
        randomNumbers.forEach(System.out::println);

        Stream.generate(() -> "Aryan").limit(3)
                .forEach(System.out::println);

        Stream.iterate(0, n -> n + 2).limit(5).forEach(System.out::println);

        Integer[] integers = {40, 60, 40, 10, -10, -70, -10};
        Stream.of(integers)
                .distinct()
                .forEach(System.out::println);

        List<Integer> sortedNumbers = Stream.of(integers).sorted().collect(Collectors.toList());
        sortedNumbers.forEach(System.out::println);

        Stream<Student> studentStream10 = Stream.of(student1, student2, student3, student4, student5);
        studentStream10.sorted(Comparator.comparing(Student::getMarks).reversed().thenComparing(Student::getName))
                .forEach(System.out::println);

        List<Integer> filteredList = Stream.of(integers).filter(num -> num > 10).collect(Collectors.toList());
        filteredList.forEach(System.out::println);

        List<Integer> modifiedList = Stream.of(integers).map(num -> num + 10).collect(Collectors.toList());
        modifiedList.forEach(System.out::println);

        Stream<Student> studentStream11 = Stream.of(student1, student2, student3, student4, student5);
        List<String> names = studentStream11.map(Student::getName).collect(Collectors.toList());
        names.forEach(System.out::println);

        Stream<Student> studentStream12 = Stream.of(student1, student2, student3, student4, student5);
        List<Student> updatedList = studentStream12.peek(student -> student.setMarks(student.getMarks() + 5))
                .collect(Collectors.toList());
        updatedList.forEach(System.out::println);

        List<List<Integer>> nestedLists = Arrays.asList(
                Arrays.asList(5, 20, 55, 10),
                Arrays.asList(15, 35, 45)
        );
        List<Integer> flatList = nestedLists.stream().flatMap(myList -> myList.stream()).collect(Collectors.toList());
        flatList.forEach(System.out::println);

        Stream<Student> studentStream13 = Stream.of(student1, student2, student3, student4, student5);
        String commaSeparatedNames = studentStream13.map(Student::getName).collect(Collectors.joining(", "));
        System.out.println(commaSeparatedNames);

        Stream<Student> studentStream14 = Stream.of(student1, student2, student3, student4, student5);
        DoubleSummaryStatistics summaryStatistics = studentStream14
                .collect(Collectors.summarizingDouble(Student::getMarks));
        System.out.println(summaryStatistics);
        System.out.println(summaryStatistics.getAverage());

        Integer[] integers3 = {43, 64, 19, -7, 86, 38};
        Map<Boolean, List<Integer>> evenOddMap = Stream.of(integers3)
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        evenOddMap.get(true).forEach(System.out::println);
        evenOddMap.get(false).forEach(System.out::println);

        Stream<Student> studentStream15 = Stream.of(student1, student2, student3, student4, student5);
        Map<String, List<Student>> studentsBySubject = studentStream15
                .collect(Collectors.groupingBy(Student::getSubject));
        System.out.println(studentsBySubject);

        Stream<Student> studentStream16 = Stream.of(student1, student2, student3, student4, student5);
        Map<String, List<String>> studentsNamesBySubject = studentStream16
                .collect(Collectors.groupingBy(Student::getSubject,
                        Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println(studentsNamesBySubject);

        Stream<Student> studentStream17 = Stream.of(student1, student2, student3, student4, student5);
        Map<String, Optional<Student>> highestScorerBySubject = studentStream17
                .collect(Collectors.groupingBy(Student::getSubject,
                        Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Student::getMarks)))));
        System.out.println(highestScorerBySubject);

        System.out.println("Iterate in Java 11, same as for loop:");
        Stream.iterate(1, n -> n < 20, n -> n + 2)
                .forEach(System.out::println);

        System.out.println("takeWhile demo:");
        Stream<Integer> intStream12 = Stream.of(21, 6, 42, 77, 36, 9, 13, 89);
        List<Integer> takeWhileList = intStream12.takeWhile(num -> num < 50)
                .collect(Collectors.toList());
        takeWhileList.forEach(System.out::println);

        System.out.println("dropWhile demo:");
        Stream<Integer> intStream13 = Stream.of(21, 6, 42, 77, 36, 9, 13, 89);
        List<Integer> dropWhileList = intStream13.dropWhile(num -> num < 50)
                .collect(Collectors.toList());
        dropWhileList.forEach(System.out::println);

    }

    private static String print(String meta) {
        System.out.println(meta);
        return "I was called";
    }
}
