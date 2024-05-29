import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        System.out.println("Student Grade Calculator");
        System.out.println("Enter the number of grades:");

        Scanner scanner = new Scanner(System.in);
        int numOfGrades = scanner.nextInt();

        double[] grades = new double[numOfGrades];
        double totalGrade = 0;

        System.out.println("Enter the grades:");
        for (int i = 0; i < numOfGrades; i++) {
            grades[i] = scanner.nextDouble();
            totalGrade += grades[i];
        }

        double averageGrade = totalGrade / numOfGrades;
        System.out.println("Average grade: " + averageGrade);

        scanner.close();
    }
}
