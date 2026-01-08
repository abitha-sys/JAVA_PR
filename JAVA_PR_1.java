import java.util.Scanner;

class Student {
    private int stu_id;
    private String stu_name;
    private double[] marks;
    private int n;
    private double avg;

    public void setInfo() {
        Scanner sid = new Scanner(System.in);

        System.out.println("Enter the id:");
        stu_id = sid.nextInt();

        sid.nextLine(); 
        System.out.println("Enter the student name:");
        stu_name = sid.nextLine();

        System.out.println("Enter the number of subjects:");
        n = sid.nextInt();

        marks = new double[n]; 

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the marks of subject " + (i + 1) + ":");
            marks[i] = sid.nextDouble();
        }
    }

    public void average() {
        double sum = 0;

        for (int i = 0; i < n; i++) {
            sum += marks[i];
        }

        avg = sum / n;
        System.out.println("Average Marks = " + avg);
        if (avg >= 40) {
            System.out.println("Result = Pass");
        } else {
            System.out.println("Result = Fail");
        }
    }

    public void getInfo() {
        System.out.println("Student ID = " + stu_id);
        System.out.println("Student Name = " + stu_name);
        average();
    }
}

class StudentInfo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setInfo();
        s1.getInfo();
    }
}
