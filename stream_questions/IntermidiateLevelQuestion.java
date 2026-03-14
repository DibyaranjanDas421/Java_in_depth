package stream_questions;

import java.lang.StackWalker.Option;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermidiateLevelQuestion {
        public static void main(String[] args) {
                // 21. Find the Sum of Digits of a Number

                int number = 12345;
                int sum = String.valueOf(number)
                                .chars().map(Character::getNumericValue)
                                .sum();
                System.out.println("sum :" + sum);

                // 22. Find the Factorial of a Number
                int num = 10;
                int[] nums = new int[num];
                for (int i = 0; i < num; i++) { // by my logic
                        nums[i] = i + 1;
                }
                Integer fac = Arrays.stream(nums).boxed().reduce(1, (a, b) -> a * b);
                System.out.println("Factorial :" + fac);

                int factorial = IntStream.rangeClosed(1, number)
                                .reduce(1, (a, b) -> a * b);
                System.out.println("Factorial: " + factorial);

                // 23. Find the Second-Largest Element in a List
                List<Integer> numbers = List.of(1, 2, 3, 4, 5);

                Integer secondMax = numbers.stream()
                                .sorted(Comparator.reverseOrder())
                                .skip(1)
                                .findFirst()
                                .orElse(0);
                System.out.println(secondMax);

                // 24. Find the Second-Smallest Element in a List
                Integer secondSmall = numbers.stream()
                                .sorted(Comparator.naturalOrder())
                                .skip(1)
                                .findFirst()
                                .orElse(0);
                System.out.println(secondSmall);

                // 25. Find the Longest String in a List
                List<String> words = List.of("apple", "banana", "kiwi");

                Optional<String> maxLengthWord = words.stream()
                                .sorted((o1, o2) -> o2.length() - o1.length())
                                .findFirst();
                System.out.println(maxLengthWord.get());

                String longest = words.stream()
                                .max(Comparator.comparingInt(String::length))
                                .orElse("");
                System.out.println("Longest Word: " + longest);

                // 26. Find the Shortest String in a List
                String shortest = words.stream()
                                .max(Comparator.comparingInt(String::length).reversed())
                                .orElse("");
                System.out.println("Longest Word: " + shortest);

                // 27. Group a List of Strings by Their Length
                Map<Integer, List<String>> res = words.stream().collect(Collectors.groupingBy(String::length));
                System.out.println("res :" + res);

                // 28. Group a List of Objects by a Specific Attribute
                List<Person> people = List.of(
                                new Person("Alice", 25),
                                new Person("Bob", 30),
                                new Person("Charlie", 25));

                Map<Integer, List<Person>> gropByAge = people.stream()
                                .collect(Collectors.groupingBy(Person::getAge));
                System.out.println("gropByAge :" + gropByAge);

                // 29. Partition a List of Integers into Even and Odd Numbers
                Map<Boolean, List<Integer>> evenOdd = numbers.stream()
                                .collect(Collectors.partitioningBy(x -> x % 2 == 0));
                System.out.println("Partition a List of Integers into Even and Odd Numbers :" + evenOdd);

                // 30. Merge Two Lists into a Single List
                List<Integer> list1 = List.of(1, 2, 3);
                List<Integer> list2 = List.of(4, 5, 6, 3);

                List<Integer> merged = Stream.concat(list1.stream(), list2.stream())
                                .collect(Collectors.toList());
                System.out.println("Merged list :" + merged);

                // 31. Find the Intersection of Two Lists
                List<Integer> interSection = list1.stream()
                                .filter(list2::contains)
                                .collect(Collectors.toList());
                System.out.println("InterSection :" + interSection);

                // 32. Find the Union of Two Lists
                List<Integer> union = Stream.concat(list1.stream(), list2.stream())
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("union :" + union);

                // 33. Find the Difference Between Two Lists
                List<Integer> diffarence = Stream.concat(list1.stream(), list2.stream())
                                .filter(n -> !list1.contains(n))
                                .distinct()
                                .collect(Collectors.toList());
                System.out.println("diffarence :" + diffarence);

                // 34. Count the Occurrences of Each Element in a List
                List<String> word = List.of("apple", "banana", "apple", "orange");
                Map<Object, Long> Occurrences = word.stream()
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                System.out.println("Occurrences :" + Occurrences);

                // 35. Count the Occurrences of Each Character in a String
                String input = "hello";
                Map<Object, Long> wordOccurrences = input.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

                System.out.println("wordOccurrences :" + wordOccurrences);
                // 36. Count the Occurrences of Each Word in a String
                String inputs = "hello world hello";
                Map<String, Long> wordcounts = Arrays.stream(inputs.split(" "))
                                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
                System.out.println("woedCount :" + wordcounts);

                // 37. Count the Occurrences of Each Vowel in a String
                Map<Character, Long> vowels = inputs.chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> "aeiou".contains(String.valueOf(c)))
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                System.out.println("vowels:" + vowels);
                // 38. Count the Occurrences of Each Digit in a String
                String digitCheck = "hello 123 world 456";
                Map<Character, Long> digicount = digitCheck.chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> Character.isDigit(c))
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
                System.out.println("digicount :" + digicount);
                // 39. Reverse a List Using Streams
                List<Integer> reverse = List.of(1, 2, 3, 4, 5);
                List<Integer> revesed = reverse.stream()
                                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                                        Collections.reverse(list);
                                        return list;
                                }));
                System.out.println("revered :" + revesed);

                // 40. Reverse a String Using Streams
                String reverseString = "hello";

                String reversed = reverseString.chars()
                                .mapToObj(c -> String.valueOf((char) c))
                                .collect(Collectors.collectingAndThen(
                                                Collectors.toList(),
                                                list -> {
                                                        Collections.reverse(list);
                                                        return String.join("", list);
                                                }));

                System.out.println(reversed);

                // String reversed = input.chars()
                // .mapToObj(c -> String.valueOf((char) c))
                // .reduce("", (a, b) -> b + a);
                // System.out.println("Reversed String: " + reversed);

        }
}

class Person {

        private String name;
        private int age;

        // Constructor
        public Person(String name, int age) {
                this.name = name;
                this.age = age;
        }

        // Getter for name
        public String getName() {
                return name;
        }

        // Setter for name
        public void setName(String name) {
                this.name = name;
        }

        // Getter for age
        public int getAge() {
                return age;
        }

        // Setter for age
        public void setAge(int age) {
                this.age = age;
        }

        @Override
        public String toString() {
                return "Person{name='" + name + "', age=" + age + "}";
        }
}
