/*Code written by Michael Luger (AKA Luggs123)
 * Purpose: convert any integer between bases 2 to 64, using standard characters.
 * */

import java.util.Scanner;
import java.math.BigInteger;

public class bigIntAny {
	//These are static so they can be modified by any method. They are reset in the toBigInt methods.
	static BigInteger inputTotal;
	static boolean negative;
	
	//Required to make use of logBigInteger, as BigInteger does not have support for logarithms.
	private static final double LOG2 = Math.log(2.0);
	
	//Execution method
	public static void main(String args[]) {
		toBigInt();
	}
	
	public static void automate(){
		
	}
	
	//Calls toNewBase through predetermined parameters rather than prompts. Good for automation.
	public static String toBigInt(String input, int fromBase, int toBase){
		inputTotal = BigInteger.valueOf(0);
		negative = false;
		
		int inputDigits = input.length();
		//Check digits right to left and calculate their value, which is then added to inputTotal
		for (int i = 0; i < inputDigits; i++) {
			switch (input.charAt(inputDigits - i - 1)){
				case 48:break; //0
				case 49:inputCheck(1, fromBase, i);//1
						break;
				case 50:inputCheck(2, fromBase, i);//2
						break;
				case 51:inputCheck(3, fromBase, i);//3
						break;
				case 52:inputCheck(4, fromBase, i);//4
						break;
				case 53:inputCheck(5, fromBase, i);//5
						break;
				case 54:inputCheck(6, fromBase, i);//6
						break;
				case 55:inputCheck(7, fromBase, i);//7
						break;
				case 56:inputCheck(8, fromBase, i);//8
						break;
				case 57:inputCheck(9, fromBase, i);//9
						break;
				case 65:inputCheck(10, fromBase, i);//A
						break;
				case 66:inputCheck(11, fromBase, i);//B
						break;
				case 67:inputCheck(12, fromBase, i);//C
						break;
				case 68:inputCheck(13, fromBase, i);//D
						break;
				case 69:inputCheck(14, fromBase, i);//E
						break;
				case 70:inputCheck(15, fromBase, i);//F
						break;
				case 71:inputCheck(16, fromBase, i);//G
						break;
				case 72:inputCheck(17, fromBase, i);//H
						break;
				case 73:inputCheck(18, fromBase, i);//I
						break;
				case 74:inputCheck(19, fromBase, i);//J
						break;
				case 75:inputCheck(20, fromBase, i);//K
						break;
				case 76:inputCheck(21, fromBase, i);//L
						break;
				case 77:inputCheck(22, fromBase, i);//M
						break;
				case 78:inputCheck(23, fromBase, i);//N
						break;
				case 79:inputCheck(24, fromBase, i);//O
						break;
				case 80:inputCheck(25, fromBase, i);//P
						break;
				case 81:inputCheck(26, fromBase, i);//Q
						break;
				case 82:inputCheck(27, fromBase, i);//R
						break;
				case 83:inputCheck(28, fromBase, i);//S
						break;
				case 84:inputCheck(29, fromBase, i);//U
						break;
				case 85:inputCheck(30, fromBase, i);//U
						break;
				case 86:inputCheck(31, fromBase, i);//V
						break;
				case 87:inputCheck(32, fromBase, i);//W
						break;
				case 88:inputCheck(33, fromBase, i);//X
						break;
				case 89:inputCheck(34, fromBase, i);//Y
						break;
				case 90:inputCheck(35, fromBase, i);//Z
						break;
				case 97:inputCheck(36, fromBase, i);//a
						break;
				case 98:inputCheck(37, fromBase, i);//b
						break;
				case 99:inputCheck(38, fromBase, i);//c
						break;
				case 100:inputCheck(39, fromBase, i);//d
						break;
				case 101:inputCheck(40, fromBase, i);//e
						break;
				case 102:inputCheck(41, fromBase, i);//f
						break;
				case 103:inputCheck(42, fromBase, i);//g
						break;
				case 104:inputCheck(43, fromBase, i);//h
						break;
				case 105:inputCheck(44, fromBase, i);//i
						break;
				case 106:inputCheck(45, fromBase, i);//j
						break;
				case 107:inputCheck(46, fromBase, i);//k
						break;
				case 108:inputCheck(47, fromBase, i);//l
						break;
				case 109:inputCheck(48, fromBase, i);//m
						break;
				case 110:inputCheck(49, fromBase, i);//n
						break;
				case 111:inputCheck(50, fromBase, i);//o
						break;
				case 112:inputCheck(51, fromBase, i);//p
						break;
				case 113:inputCheck(52, fromBase, i);//q
						break;
				case 114:inputCheck(53, fromBase, i);//r
						break;
				case 115:inputCheck(54, fromBase, i);//s
						break;
				case 116:inputCheck(55, fromBase, i);//t
						break;
				case 117:inputCheck(56, fromBase, i);//u
						break;
				case 118:inputCheck(57, fromBase, i);//v
						break;
				case 119:inputCheck(58, fromBase, i);//w
						break;
				case 120:inputCheck(59, fromBase, i);//x
						break;
				case 121:inputCheck(60, fromBase, i);//y
						break;
				case 122:inputCheck(61, fromBase, i);//z
						break;
				case 43:inputCheck(62, fromBase, i);//+
						break;
				case 47:inputCheck(63, fromBase, i);///
						break;
				case 45:if (i == inputDigits - 1){//-
							negative = true;
							break;
						} else {
							//This will trigger if a dash is anywhere but the front
							System.out.println("Your number makes no sense. Terminating. Error code 3.");
							System.exit(3);
						}
				default:System.out.println("Your number makes no sense. Terminating. Error code 4."); //Trigger on nonsense symbols
						System.exit(4);
			}
		}
		return toNewBase(toBase);
	}
	
	//Call toNewBase through prompted parameters. Good for human users.
	public static void toBigInt(){
		inputTotal = BigInteger.valueOf(0);
		negative = false;
		
		//These blocks prompt for values and return error when they are invalid.
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select the base to convert from: ");
		int fromBase = keyboard.nextInt();
		
		if (fromBase < 2||fromBase > 64) {
			System.out.println("Invalid base. Must be a positive integer from 2 to 64. Terminating. Error code 1.");
			System.exit(1);
		}
		
		System.out.println("Enter the number to be converted: ");
		String input = keyboard.next();
		
		System.out.println("Enter the number base to convert to.");
		int toBase = keyboard.nextInt();
		
		if (toBase < 2||toBase > 64) {
			System.out.println("Invalid base. Must be a positive integer from 2 to 64. Terminating. Error code 2.");
			System.exit(2);
		}
		
		int inputDigits = input.length();
		//Check digits right to left and calculate their value, which is then added to inputTotal
		for (int i = 0; i < inputDigits; i++) {
			switch (input.charAt(inputDigits - i - 1)){
				case 48:break; //0
				case 49:inputCheck(1, fromBase, i);//1
						break;
				case 50:inputCheck(2, fromBase, i);//2
						break;
				case 51:inputCheck(3, fromBase, i);//3
						break;
				case 52:inputCheck(4, fromBase, i);//4
						break;
				case 53:inputCheck(5, fromBase, i);//5
						break;
				case 54:inputCheck(6, fromBase, i);//6
						break;
				case 55:inputCheck(7, fromBase, i);//7
						break;
				case 56:inputCheck(8, fromBase, i);//8
						break;
				case 57:inputCheck(9, fromBase, i);//9
						break;
				case 65:inputCheck(10, fromBase, i);//A
						break;
				case 66:inputCheck(11, fromBase, i);//B
						break;
				case 67:inputCheck(12, fromBase, i);//C
						break;
				case 68:inputCheck(13, fromBase, i);//D
						break;
				case 69:inputCheck(14, fromBase, i);//E
						break;
				case 70:inputCheck(15, fromBase, i);//F
						break;
				case 71:inputCheck(16, fromBase, i);//G
						break;
				case 72:inputCheck(17, fromBase, i);//H
						break;
				case 73:inputCheck(18, fromBase, i);//I
						break;
				case 74:inputCheck(19, fromBase, i);//J
						break;
				case 75:inputCheck(20, fromBase, i);//K
						break;
				case 76:inputCheck(21, fromBase, i);//L
						break;
				case 77:inputCheck(22, fromBase, i);//M
						break;
				case 78:inputCheck(23, fromBase, i);//N
						break;
				case 79:inputCheck(24, fromBase, i);//O
						break;
				case 80:inputCheck(25, fromBase, i);//P
						break;
				case 81:inputCheck(26, fromBase, i);//Q
						break;
				case 82:inputCheck(27, fromBase, i);//R
						break;
				case 83:inputCheck(28, fromBase, i);//S
						break;
				case 84:inputCheck(29, fromBase, i);//U
						break;
				case 85:inputCheck(30, fromBase, i);//U
						break;
				case 86:inputCheck(31, fromBase, i);//V
						break;
				case 87:inputCheck(32, fromBase, i);//W
						break;
				case 88:inputCheck(33, fromBase, i);//X
						break;
				case 89:inputCheck(34, fromBase, i);//Y
						break;
				case 90:inputCheck(35, fromBase, i);//Z
						break;
				case 97:inputCheck(36, fromBase, i);//a
						break;
				case 98:inputCheck(37, fromBase, i);//b
						break;
				case 99:inputCheck(38, fromBase, i);//c
						break;
				case 100:inputCheck(39, fromBase, i);//d
						break;
				case 101:inputCheck(40, fromBase, i);//e
						break;
				case 102:inputCheck(41, fromBase, i);//f
						break;
				case 103:inputCheck(42, fromBase, i);//g
						break;
				case 104:inputCheck(43, fromBase, i);//h
						break;
				case 105:inputCheck(44, fromBase, i);//i
						break;
				case 106:inputCheck(45, fromBase, i);//j
						break;
				case 107:inputCheck(46, fromBase, i);//k
						break;
				case 108:inputCheck(47, fromBase, i);//l
						break;
				case 109:inputCheck(48, fromBase, i);//m
						break;
				case 110:inputCheck(49, fromBase, i);//n
						break;
				case 111:inputCheck(50, fromBase, i);//o
						break;
				case 112:inputCheck(51, fromBase, i);//p
						break;
				case 113:inputCheck(52, fromBase, i);//q
						break;
				case 114:inputCheck(53, fromBase, i);//r
						break;
				case 115:inputCheck(54, fromBase, i);//s
						break;
				case 116:inputCheck(55, fromBase, i);//t
						break;
				case 117:inputCheck(56, fromBase, i);//u
						break;
				case 118:inputCheck(57, fromBase, i);//v
						break;
				case 119:inputCheck(58, fromBase, i);//w
						break;
				case 120:inputCheck(59, fromBase, i);//x
						break;
				case 121:inputCheck(60, fromBase, i);//y
						break;
				case 122:inputCheck(61, fromBase, i);//z
						break;
				case 43:inputCheck(62, fromBase, i);//+
						break;
				case 47:inputCheck(63, fromBase, i);///
						break;
				case 45:if (i == inputDigits - 1){//-
							negative = true;
							break;
						} else {
							//Will result if a dash is anywhere else than the front
							System.out.println("Your number makes no sense. Terminating. Error code 3.");
							System.exit(3);
						}
				default:System.out.println("Your number makes no sense. Terminating. Error code 4."); //Trigger on nonsense symbol
						System.exit(4);
			}
		}
		System.out.println(input + " in base " + fromBase + " to base " + toBase + " is " + toNewBase(toBase));
	}

	//Decodes inputTotal into newBase format.
	public static String toNewBase(int toBase){
		//Simple formula for determining the number of digits a value has in a given base.
		int numberOfDigits = (int) Math.floor(logBigInteger(inputTotal)/Math.log(toBase)) + 1;
		String[] digit = new String[numberOfDigits];
		
		for (int i = 0; i < numberOfDigits; i++) {
			//These are shortcuts for the below formula.
			BigInteger mathPow1 = BigInteger.valueOf((long) Math.pow(toBase, i+1));
			BigInteger mathPow0 = BigInteger.valueOf((long) Math.pow(toBase, i));

			/* This was made as follows: to find the quantity of a digit in a given place,
			 * take the modulo of the number at the base to the power of the position.
			 * Then, subtract the modulo at the base raised to the power of the position minus one.
			 * Finally, divide by the base raised to the position minus one. 'i' refers to position minus one.
			 */
			int currentDigit = (((inputTotal.mod(mathPow1)).subtract(inputTotal.mod(mathPow0))).divide(mathPow0)).intValue();
			//Transforms the value into the digit representation.
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
				//In case of unexpected error, terminate.
				default: System.out.println("Something went wrong. Terminating. Error code 5.");
				System.exit(5);
			}
		}
		
		//Initialize String to output result.
		String output = "";
		//Starts at the greatest digit, adds that character to the end of the output String. Repeats for the length of the number.
		for (int i = numberOfDigits - 1; i >= 0 ; i--){
			output += digit[i];
		}
		if (negative) {
			output = "-" + output;
		}
		
		return output;
	}
	
	//Checks if number is valid in base and modifies inputTotal within toBigInt.
	public static void inputCheck(int digitVal, int fromBase, int power){
		if (digitVal >= fromBase){
			System.out.println("Invalid base for input. Terminating. Error code 6.");
			System.exit(6);
		} else {
			inputTotal = inputTotal.add(BigInteger.valueOf((long) (digitVal*Math.pow(fromBase, power))));
		}
	}

	//Creates logarithm of BigInteger object, which does not have such a method. Returns double.
	public static double logBigInteger(BigInteger val) {
	    int blex = val.bitLength() - 1022; // any value in 60..1023 is ok
	    if (blex > 0)
	        val = val.shiftRight(blex);
	    double res = Math.log(val.doubleValue());
	    return blex > 0 ? res + blex * LOG2 : res;
	}
}