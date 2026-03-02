package collection;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        String str = "I love java";
        String result = str.replace(" ", "").toLowerCase();

        char[] c = result.toCharArray();
        boolean[] visited = new boolean[c.length];

        for (int i = 0; i < c.length; i++) {

            if (visited[i]) {
                continue;
            }

            int count = 0;

            for (int j = 0; j < c.length; j++) {
                if (c[i] == c[j]) {
                    count++;
                    visited[j] = true;
                }
            }

            System.out.println(c[i] + " has a frequency of: " + count);
        }

        System.out.println(Arrays.toString(c));
    }
}