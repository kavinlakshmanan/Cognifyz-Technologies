import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println("Palindrome Checker");
        System.out.println("Enter a word or phrase:");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String cleanInput = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

        boolean isPalindrome = true;
        for (int i = 0; i < cleanInput.length() / 2; i++) {
            if (cleanInput.charAt(i) != cleanInput.charAt(cleanInput.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("'" + input + "' is a palindrome.");
        } else {
            System.out.println("'" + input + "' is not a palindrome.");
        }
    }
}
