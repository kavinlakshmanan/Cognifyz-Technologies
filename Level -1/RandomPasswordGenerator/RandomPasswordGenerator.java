import java.security.SecureRandom;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Random Password Generator");
        System.out.println("Enter the desired length of the password:");
        int length = scanner.nextInt();

        System.out.println("Include numbers? (yes/no):");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Include lowercase letters? (yes/no):");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Include uppercase letters? (yes/no):");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Include special characters? (yes/no):");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Generated Password:");
        System.out.println(generatePassword(length, includeNumbers, includeLowercase, includeUppercase, includeSpecial));

        scanner.close();
    }

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase,
                                           boolean includeUppercase, boolean includeSpecial) {
        String numbers = "0123456789";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-_=+";

        StringBuilder password = new StringBuilder();

        SecureRandom random = new SecureRandom();

        String validChars = "";
        if (includeNumbers) validChars += numbers;
        if (includeLowercase) validChars += lowercaseLetters;
        if (includeUppercase) validChars += uppercaseLetters;
        if (includeSpecial) validChars += specialCharacters;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
