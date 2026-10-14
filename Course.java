
import java.util.Scanner;

class Course {
    String courseName;
    String courseCode;
    String time;

    Course(String courseName, String courseCode, String time) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.time = time;
    }

    void displayCourse() {
        System.out.println(courseCode + " - " + courseName
                + " - " + time);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Course[] courses = {
            new Course("Java Programming", "C01", "Monday 9 AM"),
            new Course("Discrete Mathematics", "C02", "Tuesday 10 AM"),
            new Course("Digital Logic", "C03", "Wednesday 11 AM"),
            new Course("Computer Organization", "C04", "Thursday 1 PM"),
            new Course("Communication Skills", "C05", "Friday 2 PM")
        };

        Course[] registeredCourses = new Course[5];
        int count = 0;
        int choice;

        do {
            System.out.println("\n--- COURSE REGISTRATION AND TIMETABLE ---");
            System.out.println("1. View Available Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. View Registered Courses");
            System.out.println("4. View Timetable");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Courses:");
                    for (int i = 0; i < courses.length; i++) {
                        courses[i].displayCourse();
                    }
                    break;

                case 2:
                    if (count == registeredCourses.length) {
                        System.out.println("Registration is full!");
                        break;
                    }

                    System.out.print("Enter course code to register: ");
                    String code = sc.next();

                    boolean found = false;

                    for (int i = 0; i < courses.length; i++) {
                        if (courses[i].courseCode.equalsIgnoreCase(code)) {
                            found = true;
                            boolean alreadyRegistered = false;

                            for (int j = 0; j < count; j++) {
                                if (registeredCourses[j].courseCode
                                        .equalsIgnoreCase(code)) {
                                    alreadyRegistered = true;
                                    break;
                                }
                            }

                            if (alreadyRegistered) {
                                System.out.println(
                                        "You have already registered for this course.");
                            } else {
                                registeredCourses[count] = courses[i];
                                count++;
                                System.out.println(
                                        "Course registered successfully!");
                            }
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid course code!");
                    }
                    break;

                case 3:
                    System.out.println("\nYour Registered Courses:");

                    if (count == 0) {
                        System.out.println("No courses registered yet.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            registeredCourses[i].displayCourse();
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nYour Timetable:");

                    if (count == 0) {
                        System.out.println("Register for courses first.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            registeredCourses[i].displayCourse();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}