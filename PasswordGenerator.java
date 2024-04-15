import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    Scanner scanner;
    
    public PasswordGenerator(Scanner scanner){
        this.scanner = scanner;
    }
    
    public void Generator() {
        scanner.nextLine();
        System.out.println("Hello, welcome to the Password Generator :)\n");
        System.out.println("Answer the following questions by Yes or No\n");

        boolean useLowercase = askYesNoQuestion("Do you want Lowercase letters (abcd...) to be used?\n", scanner);
        boolean useUppercase = askYesNoQuestion("Do you want Uppercase letters (ABCD...) to be used?\n", scanner);
        boolean useNumbers = askYesNoQuestion("Do you want Numbers (1234...) to be used?\n", scanner);
        boolean useSymbols = askYesNoQuestion("Do you want Symbols (!@#$...) to be used?\n", scanner);

        System.out.print("Great! Now enter the length of the password : ");
        int passwordLength = scanner.nextInt();

        String generatedPassword = generatePassword(useLowercase, useUppercase, useNumbers, useSymbols, passwordLength);

        System.out.println("\nYour generated password -> " + generatedPassword);
    }

    private static boolean askYesNoQuestion(String question, Scanner scanner) {
        String answer = "";
        do {
           System.out.print(question);
           answer = scanner.next().toLowerCase().replace(" ", "").replace("  ","");
        }while(!answer.equals("yes") && !answer.equals("no"));
        return answer.equals("yes");
    }

    private static String generatePassword(boolean useLowercase, boolean useUppercase, boolean useNumbers, boolean useSymbols, int length) {
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numberChars = "0123456789";
        String symbolChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?`~";

        StringBuilder validChars = new StringBuilder();

        if (useLowercase) {
            validChars.append(lowercaseChars);
        }
        if (useUppercase) {
            validChars.append(uppercaseChars);
        }
        if (useNumbers) {
            validChars.append(numberChars);
        }
        if (useSymbols) {
            validChars.append(symbolChars);
        }

        if (validChars.length() == 0) {
            System.out.println("No character set selected. Exiting.");
            System.exit(0);
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            password.append(validChars.charAt(randomIndex));
        }

        return password.toString();
    }
}
