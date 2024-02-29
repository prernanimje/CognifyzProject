package level2.task3;

import level2.task3.service.DecryptionProcessor;
import level2.task3.service.EncryptionProcessor;
import level2.task3.service.FileProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        System.out.println("---------------Welcome to File Encryption/Decryption Application---------------");
        boolean continueProcessing = true;
        try (BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            while (continueProcessing) {
                System.out.println("Choose an option: ");
                System.out.println("1. Encrypt File");
                System.out.println("2. Decrypt File");
                System.out.println("3. Exit");

                System.out.println("Enter your option: ");
                int option = Integer.parseInt(userInput.readLine());
                switch ( option ) {
                    case 1 -> performOperation(new EncryptionProcessor(), userInput);
                    case 2 -> performOperation(new DecryptionProcessor(), userInput);
                    case 3 -> {
                        continueProcessing = false;
                        System.out.println("Goodbye!, Thanks for visiting File Encryption/Decryption Application");
                    }
                    default -> System.out.println("Invalid option: " + option + "\nPlease select correct option!");
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void performOperation(FileProcessor fileProcessor, BufferedReader userInput){
        try {
            System.out.println("Enter input file path:");
            String inputFileName = userInput.readLine();
            fileProcessor.processFile(inputFileName);
            System.out.println("Operation completed successfully!");
        } catch (IOException ex) {
            System.err.println("Error processing the file: " + ex.getMessage());
        }
    }
}
