package design_pattern.creational_design_pattern.builder_design_pattern;

public class User {

    private final String name;
    private final Integer age;

    public User(Builder builder) {
        this.age = builder.getAge();
        this.name = builder.getName();
    }

    @Override
    public String toString() {
        return "name :" + name + " age: " + age;
    }

    public static class Builder {
        private String name;
        private Integer age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public User build() {
            return new User(this);
        }
    }

}
