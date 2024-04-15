import java.util.Scanner;

public class PasswordStrengthChecker {

    Scanner scanner;
    
    public PasswordStrengthChecker(Scanner scanner){
        this.scanner = scanner;
    }
    
    public void tester() {

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        int strength = calculatePasswordStrength(password);

        if (strength >= 80) {
            System.out.println("\nThis is a very good password :D check the Useful Information section to make sure it satisfies the guidelines");
        } else if (strength >= 60) {
            System.out.println("\nThis is a good password :) but you can still do better");
        } else if (strength >= 40) {
            System.out.println("\nThis is a medium password :/ try making it better");
        } else {
            System.out.println("\nThis is a weak password :( definitely find a new one");
        }
    }

    private static int calculatePasswordStrength(String password) {
        
        int lengthStrength = Math.min(password.length(), 10) * 4; 
        int complexityStrength = calculateComplexityStrength(password);
        
        
        int totalStrength = lengthStrength + complexityStrength;

        return Math.min(totalStrength, 100);
    }

    private static int calculateComplexityStrength(String password) {
        
        int complexity = 0;

        if (password.matches(".*[a-z].*")) {
            complexity += 2;
        }

        if (password.matches(".*[A-Z].*")) {
            complexity += 4;
        }

        if (password.matches(".*\\d.*")) {
            complexity += 4;
        }

        if (password.matches(".*[!@#$%^&*()-_=+\\[\\]{};:'\",<.>/?`~].*")) {
            complexity += 6;
        }

        return complexity;
    }
    
    public static void information() {
		
		 System.out.println();
	     System.out.println("Use a minimum password length of 8 or more characters if permitted");
	     System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
	     System.out.println("Generate passwords randomly where feasible");
	     System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
	     System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
	             "\nusernames, relative or pet names, romantic links (current or past) " +
	             "and biographical information (e.g., ID numbers, ancestors' names or dates).");
	     System.out.println("Avoid using information that the user's colleagues and/or " +
	             "acquaintances might know to be associated with the user");
	     System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components\n");
	}

}
