package design_pattern.creational_design_pattern.builder_design_pattern;

public class Test {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setAge(20)
                .setName("Dibya")
                .build();

        System.out.println(user);
    }
}
