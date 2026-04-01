
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Map.Entry;

public class StreamStringManipulation {
        public static void main(String[] args) {
                // 72. Remove All Vowels from a String
                String input = "hello world";
                String replaced = input.replace(" ", "");
                String result = replaced.chars()
                                .mapToObj(c -> (char) c)
                                .filter(c -> "aeiouAEIOU".indexOf(c) == -1)
                                .map(String::valueOf)
                                .collect(Collectors.joining());

                System.out.println(result);

                // 72. Remove All Consonants from a String
                String removeconsunant = replaced.chars()
                                .filter(x -> "aeiou".contains(String.valueOf((char) x)))
                                .mapToObj(x -> String.valueOf((char) x))
                                .collect(Collectors.joining());
                System.out.println("removeconsunant :" + removeconsunant);

                // 73. Remove All Digits from a String
                String inputs = "hello 123 world";
                String removeSpace = inputs.replace(" ", "");

                String removeDigit = removeSpace.chars()
                                .filter(c -> !Character.isDigit(c))
                                .mapToObj(x -> String.valueOf((char) x))
                                .collect(Collectors.joining());
                System.out.println("removeDigit :" + removeDigit);

                // 74. Remove All Special Characters from a String
                String inputss = "hello@world!";

                String removeSplecialCharacter = inputss.chars()
                                .filter(c -> Character.isLetterOrDigit(c) || Character.isWhitespace(c))
                                .mapToObj(x -> String.valueOf((char) x))
                                .collect(Collectors.joining());
                System.out.println("removeSplecialCharacter :" + removeSplecialCharacter);

                // 75. Extract All Digits from a String and Sum Them

                String digitsum = "hello 123 world 456";
                Integer sum = digitsum.chars()
                                .mapToObj(x -> (char) x)
                                .filter(x -> Character.isDigit(x))
                                .map(x -> String.valueOf((char) x))
                                .map(x -> Integer.valueOf(x))
                                .reduce(0, (x, y) -> x + y);
                System.out.println("sum :" + sum);

                Integer sum1 = digitsum
                                .chars()
                                .filter(x -> Character.isDigit(x))
                                .map(Character::getNumericValue)
                                .sum();
                System.out.println("sum1 :" + sum1);

                // 76. Extract All Words from a String and Count Their Occurrences

                String words = "hello world hello";

                String[] removeSpace1 = words.split(" ");

                Map<String, Long> duplicateCount = Arrays.stream(removeSpace1)
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                System.out.println("duplicateCount :" + duplicateCount);

        }

}
