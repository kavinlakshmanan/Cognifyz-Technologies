import java.io.*;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("File Encryption/Decryption");
            System.out.println("Choose operation:");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
            int choice = Integer.parseInt(reader.readLine());

            System.out.println("Enter the file name or path:");
            String fileName = reader.readLine();

            switch (choice) {
                case 1:
                    encryptFile(fileName);
                    break;
                case 2:
                    decryptFile(fileName);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encryptFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("encrypted_" + fileName))) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character + 1);
            }
        }
        System.out.println("File encrypted successfully.");
    }

    public static void decryptFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter("decrypted_" + fileName))) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(character - 1);
            }
        }
        System.out.println("File decrypted successfully.");
    }
}
