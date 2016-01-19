/*
 * Code written by Michael Luger
 * Date: September 16th, 2015
 * Purpose: to convert any decimal number to a base of 64 at maximum
 */

import java.util.Scanner;

public class fromdecimal {
	public static void main(String args[]){
		Scanner keyboard = new Scanner(System.in);
		//accept number base
		System.out.println("Enter the number base to convert to.");
		int base = keyboard.nextInt();
		if (base < 2||base > 64) {
			System.out.println("Invalid base. Must be a positive integer from 2 to 64.\nTerminating.");
			System.exit(-1);
		}
		
		//accept integer to be converted
		System.out.println("Enter number to be converted.");
		long input = keyboard.nextLong();
		toBase(base, input);
	}
	public static void toBase(int base, long input){
		//checks if input is negative. if so, turns it positive and stores the "negative" boolean as true
		boolean negative = false;
		if (input < 0) {
			input = - input;
			negative = true;
		}
		//calculates how many digits the output will have using that base's logarithm floored plus one
		int numberOfDigits = (int) Math.floor(Math.log(input)/Math.log(base)) + 1;
		String[] digit = new String[numberOfDigits];
		
		//loop converts the number one output digit at a time
		for (int i = 0; i < numberOfDigits; i++) {
			//isolates digit
			int currentDigit = (int) ((input % Math.pow(base, i+1) - input % Math.pow(base, i)) / Math.pow(base, i));
			//chooses what the digit converts to
			switch (currentDigit) {
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9: digit[i] = currentDigit + "";
						break;
				case 10: digit[i] = "A";
						break;
				case 11: digit[i] = "B";
						break;
				case 12: digit[i] = "C";
						break;
				case 13: digit[i] = "D";
						break;
				case 14: digit[i] = "E";
						break;
				case 15: digit[i] = "F";
						break;
				case 16: digit[i] = "G";
						break;
				case 17: digit[i] = "H";
						break;
				case 18: digit[i] = "I";
						break;
				case 19: digit[i] = "J";
						break;
				case 20: digit[i] = "K";
						break;
				case 21: digit[i] = "L";
						break;
				case 22: digit[i] = "M";
						break;
				case 23: digit[i] = "N";
						break;
				case 24: digit[i] = "O";
						break;
				case 25: digit[i] = "P";
						break;
				case 26: digit[i] = "Q";
						break;
				case 27: digit[i] = "R";
						break;
				case 28: digit[i] = "S";
						break;
				case 29: digit[i] = "T";
						break;
				case 30: digit[i] = "U";
						break;
				case 31: digit[i] = "V";
						break;
				case 32: digit[i] = "W";
						break;
				case 33: digit[i] = "X";
						break;
				case 34: digit[i] = "Y";
						break;
				case 35: digit[i] = "Z";
						break;
				case 36: digit[i] = "a";
						break;
				case 37: digit[i] = "b";
						break;
				case 38: digit[i] = "c";
						break;
				case 39: digit[i] = "d";
						break;
				case 40: digit[i] = "e";
						break;
				case 41: digit[i] = "f";
						break;
				case 42: digit[i] = "g";
						break;
				case 43: digit[i] = "h";
						break;
				case 44: digit[i] = "i";
						break;
				case 45: digit[i] = "j";
						break;
				case 46: digit[i] = "k";
						break;
				case 47: digit[i] = "l";
						break;
				case 48: digit[i] = "m";
						break;
				case 49: digit[i] = "n";
						break;
				case 50: digit[i] = "o";
						break;
				case 51: digit[i] = "p";
						break;
				case 52: digit[i] = "q";
						break;
				case 53: digit[i] = "r";
						break;
				case 54: digit[i] = "s";
						break;
				case 55: digit[i] = "t";
						break;
				case 56: digit[i] = "u";
						break;
				case 57: digit[i] = "v";
						break;
				case 58: digit[i] = "w";
						break;
				case 59: digit[i] = "x";
						break;
				case 60: digit[i] = "y";
						break;
				case 61: digit[i] = "z";
						break;
				case 62: digit[i] = "+";
						break;
				case 63: digit[i] = "/";
						break;
				//in case of unexpected error, terminate
				default: System.out.println("Something went wrong.\nTerminating.");
				System.exit(1);
			}
		}
		//initialize String to output result
		String output = "";
		//starts at the greatest digit, adds that character to the end of the output String. repeats
		for (int i = numberOfDigits - 1; i >= 0 ; i--){
			output += digit[i];
		}
		if (negative) {
			output = "-" + output;
		}
		System.out.println(output);
		System.out.println("Digit code: 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/");
	}
	
}