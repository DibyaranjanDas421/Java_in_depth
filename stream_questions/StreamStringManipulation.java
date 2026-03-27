package stream_questions;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    }

}
