
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AdvanceStreamQuestions {

        public static Boolean isPalindrome(String word) {
                return IntStream.range(0, word.length() / 2)
                                .allMatch(i -> word.charAt(i) == word
                                                .charAt(word.length() - 1 - i));
        }

        public static void main(String[] args) throws IOException {

                List<String> palindromeWord = List.of("madam", "racecar", "apple", "banana", "level");

                Optional<String> longestPalindrome = palindromeWord.stream()
                                .filter(AdvanceStreamQuestions::isPalindrome)
                                .sorted(Comparator.reverseOrder())
                                .findFirst();
                System.out.println("longestPalindrome :" + longestPalindrome);

                String longestPalindrome1 = palindromeWord.stream()
                                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                                .max(Comparator.comparingInt(String::length))
                                .orElse("");
                System.out.println("Longest Palindrome: " + longestPalindrome);

                // 41. Find the Most Frequent Element in a List
                List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

                String mostFrequent = words.stream()
                                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                                .entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null);
                System.out.println("mostFrequent:" + mostFrequent);

                // 42. Find the Least Frequent Element in a List

                String leastFrequent = words.stream()
                                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                                .entrySet().stream()
                                .min(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null);
                System.out.println("leastFrequent:" + leastFrequent);

                // 43. Duplicate Charecters in a String
                String inpuString = "I Love Java";
                String[] s1 = inpuString.split(" ");
                String s2 = String.join("", s1);
                s2.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() > 2)
                                .forEach(System.out::println);

                String input = "hello";
                Optional<Map.Entry<Character, Long>> nonRepeat = input.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() == 1)
                                .findFirst();
                System.out.println("nonRepeat:" + nonRepeat.get());
                // 44. Find the First Repeated Character in a String

                Optional<Map.Entry<Character, Long>> Repeated = input.chars()
                                .mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                                .entrySet()
                                .stream()
                                .filter(entry -> entry.getValue() > 1)
                                .findFirst();
                System.out.println("Repeated:" + Repeated.get());

                // 45. Check if a String is a Palindrome

                String inputPalindrome = "madam";
                Boolean isPalindrome = IntStream.range(0, inputPalindrome.length() / 2)
                                .allMatch(i -> inputPalindrome.charAt(i) == inputPalindrome
                                                .charAt(inputPalindrome.length() - 1 - i));
                System.out.println("isPalindrome:" + isPalindrome);

                // 46. Find All Anagrams of a String from a List
                List<String> wordsAnagrams = List.of("listen", "silent", "enlist", "google", "inlets");
                String target = "silent";

                List<String> anagrams = wordsAnagrams.stream()
                                .filter(word -> Arrays.equals(
                                                word.chars().sorted().toArray(), target.chars().sorted().toArray()))
                                .collect(Collectors.toList());
                System.out.println("anagrams :" + anagrams);

                // 47. Generate the Fibonacci Sequence Using Streams

                Stream.iterate(new int[] { 0, 1 }, fib -> new int[] { fib[1], fib[0] + fib[1] })
                                .limit(10)
                                .map(fib -> fib[0])
                                .forEach(System.out::println);
                // 48. Generate a List of Random Numbers Using Streams

                IntStream randomStream = new Random().ints(5);
                randomStream.forEach(System.out::println);
                // 49. Flatten a List of Lists into a Single List
                List<List<Integer>> listOfLists = List.of(
                                List.of(1, 2, 3),
                                List.of(4, 5, 6),
                                List.of(7, 8, 9));
                List<Integer> singleList = listOfLists.stream()
                                .flatMap(x -> x.stream())
                                .toList();
                System.out.println("singleList :" + singleList);
                // 50. Find the Sum of All Even Numbers in a Nested List
                DoubleSummaryStatistics sum = listOfLists.stream()
                                .flatMap(x -> x.stream())
                                .filter(x -> x % 2 == 0)
                                .collect(Collectors.summarizingDouble(x -> x));
                System.out.println(sum.getSum());

                Optional<Integer> sum1 = listOfLists.stream()
                                .flatMap(x -> x.stream())
                                .filter(x -> x % 2 == 0)
                                .reduce((x, y) -> Integer.sum(x, y));
                System.out.println("sum1:" + sum1);
                // 51. Find the Sum of All Odd Numbers in a Nested List
                Integer sumOfOdd = listOfLists.stream()
                                .flatMap(List::stream)
                                .filter(x -> x % 2 != 0)
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("sumOfOdd:" + sumOfOdd);
                // 52. Find the Longest Palindrome in a List of Strings

                // 53. Find the Shortest Palindrome in a List of Strings
                Optional<String> shortestPalindrome = palindromeWord.stream()
                                .filter(AdvanceStreamQuestions::isPalindrome)
                                .sorted()
                                .findFirst();
                System.out.println("shortestPalindrome :" + shortestPalindrome);

                // 54. Find the Longest Word in a String
                String inputs = "hello world this is a test";
                String[] longStrings = inputs.split(" ");
                Optional<String> longestWord = Arrays.stream(longStrings).max(Comparator.comparing(String::length));
                System.out.println("longestWord :" + longestWord);

                // 55. Find the Shortest Word in a String
                Optional<String> shortestWord = Arrays.stream(longStrings).min(Comparator.comparing(String::length));
                System.out.println("shortestWord :" + shortestWord);

                // 56. Find the Number of Words in a String
                List<Integer> countWords = Arrays.stream(longStrings).map(String::length).toList();
                System.out.println("countWords:" + countWords);

                long wordCount = Arrays.stream(input.split(" ")).count();
                System.out.println("Word Count: " + wordCount);
                // 57. Find the Number of Lines in a File

                Path path = Paths.get("D:\\Java_In_depth\\collection\\Test.java");

                try {
                        long lineCount = Files.lines(path).count();
                        System.out.println("line count" + lineCount);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                // 58. Find the Number of Characters in a File
                try {
                        long charCount = Files.lines(path)
                                        .flatMapToInt(String::chars)
                                        .count();
                        System.out.println("charCount :" + charCount);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                // 59. Find the Number of Words in a File
                try {
                        long wordCounts = Files.lines(path)
                                        .flatMap(line -> Arrays.stream(line.split(" ")))
                                        .count();
                        System.out.println("Word Count: " + wordCounts);
                } catch (IOException e) {
                        e.printStackTrace();
                }

                // 60. Find the Number of Unique Words in a File

                Path path1 = Paths.get("D:\\Java_In_depth\\collection\\Test.java");

                try {
                        long uniqueWord = Files.lines(path1)
                                        .flatMap(line -> Arrays.stream(line.split(" ")))
                                        .distinct()
                                        .count();
                        System.out.println("uniqueWord: " + uniqueWord);
                } catch (IOException e) {
                        e.printStackTrace();
                }
                // //61-Filter employees who belong to the "IT" department

                // From those, select employees with salary greater than 50,000

                // Transform the result into a list of employee names only

                // Return the final result as a List<String>

                List<Employee> employees = List.of(
                                new Employee(1, "Amit", 60000, "IT"),
                                new Employee(2, "Neha", 75000, "IT"),
                                new Employee(3, "Rahul", 45000, "HR"),
                                new Employee(4, "Priya", 80000, "IT"),
                                new Employee(5, "Ankit", 30000, "Finance"));
                List<String> result = employees.stream()
                                .filter(x -> x.department.equals("IT"))
                                .filter(x -> x.salary > 50000)
                                .map(Employee::getName)
                                .toList();
                System.out.println("results :" + result);

                // 62-Group High-Paid Employees by Department
                LinkedHashMap<String, List<String>> highPaidEmployee = employees.stream()
                                .filter(e -> e.salary > 50000)
                                .collect(Collectors.groupingBy(x -> x.department, LinkedHashMap::new,
                                                Collectors.mapping(Employee::getName, Collectors.toList())));
                System.out.println("Group High-Paid Employees by Department :" + highPaidEmployee);

                // 63-Calculate Average Salary by Department from a CSV File
                Path p1 = Paths.get("D:\\Java_In_depth\\stream_questions\\data.csv");
                Map<String, Double> avgSalary = Files.lines(p1)
                                .skip(1)
                                .map(line -> line.split(","))
                                .collect(Collectors.groupingBy(fields -> fields[1],
                                                Collectors.averagingDouble(fields -> Double.parseDouble(fields[2]))));
                System.out.println("Average Salary:" + avgSalary);

                // //64- Problem Statement

                // You are given a JSON string representing a list of people:

                // [
                // {"name":"Alice","age":25},
                // {"name":"Bob","age":30}
                // ]
                // Your Task:
                // Convert the JSON string into a list of Person objects using Jackson.
                // From the list, filter out only those people whose age is greater than 25.
                // Extract the names of those filtered people.
                // Return the result as a List<String>.

                // String json =
                // "[{\"name\":\"Amit\",\"age\":25},{\"name\":\"Rohit\",\"age\":30}]";
                // List<Person> people = new ObjectMapper().readValue(json, new
                // TypeReference<List<Person>>() {
                // });
                // List<String> validNames = people.stream()
                // .filter(p -> p.getAge() > 25)
                // .map(Person::getName)
                // .collect(Collectors.toList());
                // System.out.println("Valid Names: " + validNames);

                // 64. Combine Multiple Asynchronous Tasks
                CompletableFuture<List<Integer>> future1 = CompletableFuture.supplyAsync(() -> List.of(1, 2, 3));
                CompletableFuture<List<Integer>> future2 = CompletableFuture.supplyAsync(() -> List.of(4, 5, 6));

                List<Integer> list = Stream.of(future1, future2)
                                .map(CompletableFuture::join)
                                .flatMap(List::stream)
                                .toList();
                System.out.println("Async task:" + list);

                // 65. Process Large Datasets in Parallel

                List<Integer> largeData = IntStream.rangeClosed(0, 100000).boxed().toList();

                int largeSum = largeData.parallelStream()
                                .mapToInt(Integer::intValue)
                                .sum();
                System.out.println("largeSum :" + largeSum);

                // 66- Handle Exceptions in Streams
                List<String> numbers = List.of("1", "2", "three", "4");

                List<Integer> parsedInt = numbers.stream()
                                .flatMap(s -> {
                                        try {
                                                return Stream.of(Integer.parseInt(s));
                                        } catch (NumberFormatException e) {
                                                return Stream.empty();
                                        }
                                }).collect(Collectors.toList());
                System.out.println("ParsedNumber :" + parsedInt);

                // 68. Group Employees by Department and Calculate Average Salary
                List<Employee> employees1 = List.of(
                                new Employee(1, "Amit", 60000, "IT"),
                                new Employee(2, "Neha", 75000, "IT"),
                                new Employee(3, "Rahul", 45000, "HR"),
                                new Employee(4, "Priya", 80000, "IT"),
                                new Employee(5, "Ankit", 30000, "Finance"));
                Map<String, Double> avgSalaryByDept = employees1.stream()
                                .collect(Collectors.groupingBy(Employee::getDepartment,
                                                Collectors.averagingDouble(Employee::getSalary)));
                System.out.println("Average Salary by Department: " + avgSalaryByDept);
                // 69-Use Custom Collectors to Calculate Statistics
                List<Integer> nums = List.of(1, 2, 3, 4, 5);

                DoubleSummaryStatistics statictics = nums.stream()
                                .collect(Collectors.summarizingDouble(Integer::intValue));
                // 70- Find the Top N Highest-Paid Employees
                System.out.println(employees1.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .limit(2)
                                .map(Employee::getName)
                                .collect(Collectors.toList()));
                // 71. Find the Top N Most Frequent Words in a Text File

                Path path3 = Paths.get("D:\\Java_In_depth\\stream_questions\\top_n_words.csv");
                try (Stream<String> lines = Files.lines(path3)) {
                        List<String> topNWords = lines
                                        .map(line -> line.toLowerCase().replaceAll("[^a-z ]", " "))
                                        .flatMap(line -> Arrays.stream(line.split("\\s+")))
                                        .filter(word -> !word.isEmpty())
                                        .collect(Collectors.groupingBy(w -> w, Collectors.counting()))
                                        .entrySet()
                                        .stream()
                                        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                                        .limit(3)
                                        .map(Map.Entry::getKey)
                                        .sorted(Comparator.naturalOrder())
                                        .toList();
                        System.out.println("topNWords :" + topNWords);
                }

        }

}

class Employee {
        int id;
        String name;
        double salary;
        String department;

        public Employee(int id, String name, double salary, String department) {
                this.id = id;
                this.name = name;
                this.salary = salary;
                this.department = department;
        }

        // Getter methods (important for Streams)
        public int getId() {
                return id;
        }

        public String getName() {
                return name;
        }

        public double getSalary() {
                return salary;
        }

        public String getDepartment() {
                return department;
        }
}

class Person1 {
        private String name;
        private Integer age;

        public Person1(String name, Integer age) {
                this.name = name;
                this.age = age;
        }

        public String getName() {
                return name;
        }

        public Integer getAge() {
                return age;
        }

}
