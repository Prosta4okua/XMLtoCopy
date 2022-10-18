// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener {
    String attendance;

    private final JButton absent;
    private final JButton present;
    private final JButton all;


    public MyFrame(String attendance) {
        int width = 300;
        int height = 40;

        this.attendance = attendance;


        setTitle("Виберіть кого ви хочете скопіювати");
        setBounds(300, 200, 900, 500);
        setLocationRelativeTo(null);

        absent = new JButton("Тільки відсутні");
        absent.setFont(new Font("Arial", Font.PLAIN, 15));
        absent.setSize(width, height);
        absent.addActionListener(this);

        present = new JButton("Тільки присутні");
        present.setFont(new Font("Arial", Font.PLAIN, 15));
        present.setSize(width, height);
        present.setLocation(width, 0);
        present.addActionListener(this);

        all = new JButton("Повний список");
        all.setFont(new Font("Arial", Font.PLAIN, 15));
        all.setSize(width, height);
        all.setLocation(width * 2, 0);
        all.addActionListener(this);

        JPanel box = new JPanel(new GridLayout(2, 1));
        box.add(present);
        box.add(all);
        box.add(absent);
        JPanel west = new JPanel(new GridBagLayout());
        west.add(box);
        getContentPane().add(west, BorderLayout.WEST);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        String res;
        StringBuilder sb = new StringBuilder();
        String[] tokens = attendance.split("\n");
        if (e.getSource() == absent) {
            for (String token : tokens) {
                if (token.contains("\tн"))
                    sb.append(token).append("\n");
            }
            res = sb.toString();
            System.out.println(res);
            copyToClipboard(res);
        } else if (e.getSource() == present) {
            for (String token : tokens) {
                if (token.contains("+"))
                    sb.append(token).append("\n");
            }
            res = sb.toString();
            System.out.println(res);
            copyToClipboard(res);

        } else if (e.getSource() == all) {
            System.out.println(attendance);
            copyToClipboard(attendance);
        }
        infoBox("Присутність скопійована", "Був сформований список усіх студентів");
    }


    private static void copyToClipboard(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
