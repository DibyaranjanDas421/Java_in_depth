package stream_questions;

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

    }

}
