package tools;

public class Student {
    public String nameAndSurname;
    public String data1;
    public String data2;

    public Student(String nameAndSurname, String data1, String data2) {
        this.nameAndSurname = nameAndSurname;
        this.data1 = data1;
        this.data2 = data2;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public Student() {
        this.nameAndSurname = "111";
        this.data1 = "222";
        this.data2 = "333";
    }

    @Override
    public String toString() {
        return "[[[ " + nameAndSurname + " | " + data1 + " | " + data2 + " ]]]\n";
    }
}
