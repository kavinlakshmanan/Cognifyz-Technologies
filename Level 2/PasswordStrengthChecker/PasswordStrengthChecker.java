import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Password Strength Checker");
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        int length = password.length();
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");

        System.out.println("Password strength:");

        if (length < 6) {
            System.out.println("Weak - Password length should be at least 6 characters.");
        } else if (length < 10) {
            System.out.println("Moderate - Password length is good, but consider adding more characters.");
        } else {
            System.out.println("Strong - Password length is good.");
        }

        if (!hasUppercase) {
            System.out.println("Weak - Password should contain at least one uppercase letter.");
        }

        if (!hasLowercase) {
            System.out.println("Weak - Password should contain at least one lowercase letter.");
        }

        if (!hasDigit) {
            System.out.println("Weak - Password should contain at least one digit.");
        }

        if (!hasSpecial) {
            System.out.println("Weak - Password should contain at least one special character.");
        }

        if (length >= 10 && hasUppercase && hasLowercase && hasDigit && hasSpecial) {
            System.out.println("Very Strong - Password meets all criteria.");
        }

        scanner.close();
    }
}
