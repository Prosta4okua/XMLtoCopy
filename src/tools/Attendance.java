package tools;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Attendance {

    public void run() {
        chooseFile();
    }

    public String chooseFile() {

        FileDialog dialog = new FileDialog((Frame) null, "Вибір файлу для відвідуваності");
        dialog.setDirectory("C:\\Users\\Danylo\\Downloads");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Тільки comma separated values", ".csv");
        dialog.setFilenameFilter(((dir, name) -> name.endsWith(".csv")));
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String filePath = dialog.getFile();
        System.out.println(filePath + " chosen.");

//        analyzeCsv(dialog.getFiles());
        File file = dialog.getFiles()[0];
        try {
            return analyzeCsv(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private String analyzeCsv(File file) throws IOException {
        StringBuilder sb = new StringBuilder();

        String string = null;
        try {
            string = Files.readString(Path.of(file.getAbsolutePath()));
            System.out.println(string);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int firstIndex = string.indexOf("Full Name");
        string = string.substring(firstIndex);

//        String[] studentStringArray = string.replace("\n", ",").replace("\"", "").split(",");

        StudentList studentList = new StudentList();

        ArrayList<String[]> myGroup = studentList.getStudents();

        String finalString = string;

        String temp = "Студент(-ка) | Чи присутній?";
        sb.append(temp).append("\n");
        System.out.println(temp);
        myGroup.forEach(e -> {
            boolean isPresent = false;
            for (int i = 0; i < e.length; i++) {
                if (finalString.contains(e[i])) isPresent = true;

            }
            String present = isPresent ? "+" : "н";
            String[] surnameAndName = e[0].split(" ");
            String surname = surnameAndName[1];
            String name = surnameAndName[0];

            String str = surname + " " + name + "\t\t\t" + present;
            sb.append(str).append('\n');
            System.out.println(str);
        });

        return sb.toString();
    }
}
