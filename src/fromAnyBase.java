import java.util.Scanner;

public class fromAnyBase{
	public static int fromBase;
	public static int toBase;
	public static long inputTotal;
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select the base to convert from: ");
		fromBase = keyboard.nextInt();
		
		while (true){
			if (fromBase < 2||fromBase > 64) {
				System.out.println("Invalid base. Must be a positive integer from 2 to 64. Try again.");
				fromBase = keyboard.nextInt();
			} else {
				break;
			}
		}
		
		System.out.println("Enter the number to be converted: ");
		String input = keyboard.next();
		
		System.out.println("Enter the number base to convert to.");
		toBase = keyboard.nextInt();
		
		while (true){
			if (toBase < 2||toBase > 64) {
				System.out.println("Invalid base. Must be a positive integer from 2 to 64. Try again.");
				toBase = keyboard.nextInt();
			} else {
				break;
			}
		}
		
		int inputDigits = input.length();
		char[] inputDigit = new char[inputDigits];
		for (int i = 0; i < inputDigits; i++) {
			switch (input.charAt(inputDigits-i-1)){
				case 48:inputCheck(0, i);//0
						break;
				case 49:inputCheck(1, i);//1
						break;
				case 50:inputCheck(2, i);//2
						break;
				case 51:inputCheck(3, i);//3
						break;
				case 52:inputCheck(4, i);//4
						break;
				case 53:inputCheck(5, i);//5
						break;
				case 54:inputCheck(6, i);//6
						break;
				case 55:inputCheck(7, i);//7
						break;
				case 56:inputCheck(8, i);//8
						break;
				case 57:inputCheck(9, i);//9
						break;
				case 65:inputCheck(10, i);//A
						break;
				case 66:inputCheck(11, i);//B
						break;
				case 67:inputCheck(12, i);//C
						break;
				case 68:inputCheck(13, i);//D
						break;
				case 69:inputCheck(14, i);//E
						break;
				case 70:inputCheck(15, i);//F
						break;
				case 71:inputCheck(16, i);//G
						break;
				case 72:inputCheck(17, i);//H
						break;
				case 73:inputCheck(18, i);//I
						break;
				case 74:inputCheck(19, i);//J
						break;
				case 75:inputCheck(20, i);//K
						break;
				case 76:inputCheck(21, i);//L
						break;
				case 77:inputCheck(22, i);//M
						break;
				case 78:inputCheck(23, i);//N
						break;
				case 79:inputCheck(24, i);//O
						break;
				case 80:inputCheck(25, i);//P
						break;
				case 81:inputCheck(26, i);//Q
						break;
				case 82:inputCheck(27, i);//R
						break;
				case 83:inputCheck(28, i);//S
						break;
				case 84:inputCheck(29, i);//T
						break;
				case 85:inputCheck(30, i);//U
						break;
				case 86:inputCheck(31, i);//V
						break;
				case 87:inputCheck(32, i);//W
						break;
				case 88:inputCheck(33, i);//X
						break;
				case 89:inputCheck(34, i);//Y
						break;
				case 90:inputCheck(35, i);//Z
						break;		
				case 97:inputCheck(36, i);//a
						break;
				case 98:inputCheck(37, i);//b
						break;
				case 99:inputCheck(38, i);//c
						break;
				case 100:inputCheck(39, i);//d
						break;
				case 101:inputCheck(40, i);//e
						break;
				case 102:inputCheck(41, i);//f
						break;
				case 103:inputCheck(42, i);//g
						break;
				case 104:inputCheck(43, i);//h
						break;
				case 105:inputCheck(44, i);//i
						break;
				case 106:inputCheck(45, i);//j
						break;
				case 107:inputCheck(46, i);//k
						break;
				case 108:inputCheck(47, i);//l
						break;
				case 109:inputCheck(48, i);//m
						break;
				case 110:inputCheck(49, i);//n
						break;
				case 111:inputCheck(50, i);//o
						break;
				case 112:inputCheck(51, i);//p
						break;
				case 113:inputCheck(52, i);//q
						break;
				case 114:inputCheck(53, i);//r
						break;
				case 115:inputCheck(54, i);//s
						break;
				case 116:inputCheck(55, i);//t
						break;
				case 117:inputCheck(56, i);//u
						break;
				case 118:inputCheck(57, i);//v
						break;
				case 119:inputCheck(58, i);//w
						break;
				case 120:inputCheck(59, i);//x
						break;
				case 121:inputCheck(60, i);//y
						break;
				case 122:inputCheck(61, i);//z
						break;
				case 43:inputCheck(62, i);//+
						break;
				case 47:inputCheck(63, i);///
						break;
			}
		}
		toBase(toBase, inputTotal);
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
	public static void inputCheck(int change, int power){
		if (change > fromBase - 1){
			System.out.println("Invalid base for input. Terminating.");
			System.exit(-1);
		} else {
			inputTotal += change*Math.pow(fromBase, power);
		}
	}
}