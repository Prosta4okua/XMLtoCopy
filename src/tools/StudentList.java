package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    private final String PATH = "C:\\Users\\Danylo\\Desktop\\University\\5 term\\GroupLeader\\Starosta\\Starosta\\res\\students.txt";
    private ArrayList<String[]> students;

    public StudentList() throws IOException {
        students = new ArrayList<>();

        Scanner scanner;
        scanner = new Scanner(new File(PATH));

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] stringArray = line.split(",");

            students.add(stringArray);
        }
    }

    public static void main(String[] args) {
        try {
            new StudentList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String[]> getStudents() {
        return students;
    }
}
