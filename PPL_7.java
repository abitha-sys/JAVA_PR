import java.io.*;
import java.util.*;

class Student {
    String name;
    int age;
    String grade;

    Student(String n, int a, String g) {
        name = n;
        age = a;
        grade = g;
    }

    void display() {
        System.out.println(name + " | " + age + " | " + grade);
    }

    public String toString() {
        return name + "," + age + "," + grade;
    }
}

public class StudentManagement {

    ArrayList<Student> list = new ArrayList<>();
    String file = "students.txt";
    Scanner sc = new Scanner(System.in);

    // Save file
    void saveFile() {
        try (PrintWriter pw = new PrintWriter(file)) {
            for (Student s : list) {
                pw.println(s);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Load file
    void loadFile() {
        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                String[] d = sc.nextLine().split(",");
                list.add(new Student(d[0], Integer.parseInt(d[1]), d[2]));
            }
        } catch (Exception e) {}
    }

    // Add
    void addStudent() {
        System.out.print("Enter Name: ");
        String n = sc.next();
        System.out.print("Enter Age: ");
        int a = sc.nextInt();
        System.out.print("Enter Grade: ");
        String g = sc.next();

        list.add(new Student(n, a, g));
        saveFile();
        System.out.println("Added");
    }

    // Update
    void updateStudent() {
        System.out.print("Enter Name to Update: ");
        String n = sc.next();

        for (Student s : list) {
            if (s.name.equalsIgnoreCase(n)) {
                System.out.print("New Age: ");
                s.age = sc.nextInt();
                System.out.print("New Grade: ");
                s.grade = sc.next();
                saveFile();
                System.out.println("Updated");
                return;
            }
        }
        System.out.println("Not Found");
    }

    // Delete
    void deleteStudent() {
        System.out.print("Enter Name to Delete: ");
        String n = sc.next();

        for (Student s : list) {
            if (s.name.equalsIgnoreCase(n)) {
                list.remove(s);
                saveFile();
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Not Found");
    }

    // Search
    void searchStudent() {
        System.out.print("Enter Name to Search: ");
        String n = sc.next();

        for (Student s : list) {
            if (s.name.equalsIgnoreCase(n)) {
                s.display();
                return;
            }
        }
        System.out.println("Not Found");
    }

    // Display
    void displayAll() {
        for (Student s : list) {
            s.display();
        }
    }

    public static void main(String[] args) {

        StudentManagement m = new StudentManagement();
        m.loadFile();

        int ch;

        do {
            System.out.println("\n1.Add 2.Update 3.Delete 4.Search 5.Display 6.Exit");
            System.out.print("Enter Choice: ");
            ch = m.sc.nextInt();

            switch (ch) {
                case 1:
                    m.addStudent();
                    break;
                case 2:
                    m.updateStudent();
                    break;
                case 3:
                    m.deleteStudent();
                    break;
                case 4:
                    m.searchStudent();
                    break;
                case 5:
                    m.displayAll();
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }

        } while (ch != 6);
    }
}
