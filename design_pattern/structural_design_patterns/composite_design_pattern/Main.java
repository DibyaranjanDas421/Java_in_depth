package design_pattern.structural_design_patterns.composite_design_pattern;

public class Main {
    public static void main(String[] args) {

        Component file1 = new File("resume.pdf");
        Component file2 = new File("photo.png");

        Folder folder1 = new Folder("Documents");
        folder1.add(file1);
        folder1.add(file2);

        Folder root = new Folder("Root");
        root.add(folder1);

        root.show();
    }
}
