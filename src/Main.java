import tools.Attendance;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Main {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame(new Attendance().chooseFile());

    }


}