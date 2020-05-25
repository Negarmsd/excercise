import java.util.Scanner;
//import java.util.Arrays;

/**
 * this class is to caculate the sum of the given coins as the gives them as Euro in result.
 * @param getInput gets the coins.
 * @param coin all the given coins as an array of integer
 * @param sum the sum of all the money
 * @param Euro caculates the money in Euro
 */
class Euro {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("input example : 1,2,10,");
		String getInput = input.next();
		int[] coin = convertStringToInt(getInput);
		int sum = sumOfMoney(coin, coin.length);
		int euro = euroCent(sum);
		printArray(coin, sum, euro);
	}
/**
 * this method prints the coins and the sum of money.
 * @param size the length of coin array.
 */

	public static void printArray(int[] coin, int sum, int euro) {
		int size = coin.length;
		System.out.print("{");
		for (int i = 0; i < size - 1; i++) {
		System.out.print(coin[i]);
		System.out.print(",");
		}

		System.out.print(coin[size - 1] + ":" + sum + "}\n");
		System.out.printf(" %d Euro and %d Cent \n", euro, sum % 100);
	}

/**this method converts the given coins as String into an integer array.
 * @param String money the given coins converted into array Sting.
 * @param coin the coins as integer array.
 * @return given coins as integer array.
 */
	public static int[] convertStringToInt(String getInput) {
		String[] money = getInput.split(",");
		int[] coin = new int[money.length];
		for (int i = 0; i < money.length; i++) {
			coin[i] = Integer.parseInt(money[i]);
		}
		return coin;
	}

/**Calculates the sum of given coins.
 * @param coin the given coins.
 * @param lengthOfCoin length of array coin.
 * @param sum the sum of the given coins.
 * @return sum of the given coins
 */

	public static int sumOfMoney(int[] coin, int lengthOfCoin) {
		int sum = 0;
		for (int i = 0; i < lengthOfCoin; i++) {
			sum += coin[i];
		}
		return sum;
	}

/**calculates the money in Euro if the sum of the given coins was bigger than 100 but if the sum was less than 100 Euro equals zero.
 * @param sum the sum of the given coins
 * @param euro the sum of Euros.
 * @return euro.
 */
	public static int euroCent(int sum) {
		int euro = 0;
		if (sum >= 100) {
			euro = sum / 100;
		} else {
			euro = 0;
		}
		return euro;
	} 
}
