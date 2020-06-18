//14. Traditional password entry schemes are susceptible to “shoulder surfing” in which
//an attacker watches an unsuspecting user enter his or her password or PIN number
//and uses it later to gain access to the account. One way to combat this problem
//is with a randomized challenge-response system. In these systems, the user enters
//different information every time based on a secret in response to a randomly generated
//challenge. Consider the following scheme in which the password consists of a
//five-digit PIN number (00000 to 99999). Each digit is assigned a random number
//that is 1, 2, or 3. The user enters the random numbers that correspond to their PIN
//instead of their actual PIN numbers.
//For example, consider an actual PIN number of 12345. To authenticate it, the user
//would be presented with a screen such as the following:
//PIN: 0 1 2 3 4 5 6 7 8 9
//NUM: 3 2 3 1 1 3 2 2 1 3
//The user would enter 23113 instead of 12345. This does not divulge the password
//even if an attacker intercepts the entry because 23113 could correspond to other
//PIN numbers, such as 69440 or 70439. The next time the user logs in, a different
//sequence of random numbers would be generated, such as the following:
//PIN: 0 1 2 3 4 5 6 7 8 9
//NUM: 1 1 2 3 1 2 2 3 3 3
//Your program should simulate the authentication process. Store an actual PIN
//number in your program. The program should use an array to assign random
//numbers to the digits from 0 to 9. Output the random digits to the screen, input
//the response from the user, and output whether or not the user’s response correctly
//matches the PIN number.

package ProgrammingProject14;

import java.util.*;

public class Encryption {

	static private int PIN[] = new int[10];
	static int[] copyPIN = new int[PIN.length];
	static private int NUM[] = new int[PIN.length];
	static int copyNUM[] = new int[NUM.length];
	static final String password = "12345"; // 5 values - constant predefined
	static String enteredPass;
	static Random rng = new Random();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		setPINNUM();
		getPIN();

		int count = 0;
		while (count < 3) {
			System.out.println("\nEnter your password using the corresponding keys in NUM.");
			enteredPass = input.next();
			int letters = 0;
			for (int i = 0; i < enteredPass.length(); i++) {
				if (enteredPass.charAt(i) != ' ') {
					letters++;
				}
			}
			if (letters < 5) {
				System.out.println("The password must be five digits long.");
				count++;
				System.out.println("You have " + (3 - count) + " attempts left.");
				continue;
			}

			if (!verifyPIN(enteredPass)) {
				System.out.println("Incorrect pin. Try again.");
				count++;
				System.out.println("You have " + (3 - count) + " attempts left.");
				continue;
			} else {
				System.out.println("Pin correct.");
				System.exit(0);
			}
		}
	}

	public Encryption() { // default constructor
		// default for PIN[]
		for (int i = 0; i < PIN.length; i++) {
			PIN[i] = i;
			NUM[i] = rng.nextInt(3) + 1;
		}
	}

	public static void setPINNUM() { // default constructor
		// default for PIN[]
		for (int i = 0; i < PIN.length; i++) {
			PIN[i] = i;
			NUM[i] = rng.nextInt(3) + 1;
		}
	}

	public static void getPIN() {

		System.out.print("PIN : ");
		for (int i = 0; i < copyPIN.length; i++) {
			copyPIN[i] = PIN[i];
			System.out.print(copyPIN[i] + " ");
		}
		System.out.println();
		getNUM();
		// return ( copyPIN ); returns the memory location of copyPIN
	}

	public static void getNUM() {
		System.out.print("NUM : ");
		for (int i = 0; i < copyNUM.length; i++) {
			copyNUM[i] = NUM[i];
			System.out.print(copyNUM[i] + " ");
		}
		System.out.println();
	}

	public static boolean verifyPIN(String enteredPass) {
		String verification = "";
		for (int i = 0; i < 5; i++) {		//because password is unique and constant, we compare the enteredPass to the location of the predefined password
			verification += copyNUM[i + 1];
		}
		if(enteredPass.equals(verification)) {
			return true;
		} else {
			return false;
		}
	}
}
