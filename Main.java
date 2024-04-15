import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
		System.out.println("Welcome to Ziz Password Services :)\n");
		while(choice != 4) {
			System.out.println("Enter 1 - Password Generator");
			System.out.println("Enter 2 - Password Strength Check");
			System.out.println("Enter 3 - Useful Information");
			System.out.println("Enter 4 - Quit");
			System.out.print("Choice: ");
			choice = scan.nextInt();
			switch(choice) {
				case 1 :
					PasswordGenerator passwordGenerator = new PasswordGenerator(scanner); 
					passwordGenerator.generator();
					break;
				case 2 :
					PasswordStrengthChecker passwordStrengthChecker = new PasswordStrengthChecker(scanner);
					PasswordStrengthChecker.tester();
					break;
				case 3 :
					PasswordStrengthChecker.information();
					break;
			}
		}
		scanner.close();
	}

}
