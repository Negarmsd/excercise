import java.util.Arrays;
import java.util.Scanner;
/**
 * class Crypto encrypts or decrypts a given sentence with given keyword.
 * @param getInput to decide whether encrypt or decrypt must happen.
 * @param sentence is for getting the words.
 * @param words an Array of characters from a given word.
 * @param lengthOfWords the length of Array words.
 * @param keys is for getting the keyword. 
 * @param key an Array of characters from given a keyword.
 * @param lengthOfKey is the length of Array keyword.
 * after getting the word and keyword method extendOrCutArray extend or cuts the keyword in order to fit the given word.
 * @param keyExtend the extended or shortened version of the keyword.
 * @param encrypted the encrypted word.
 * @param decrypted the decrypted word.
 * @param lengthOfKeyExtend the length of Array keyExtend
 * 
 * 
 */

class CryptoII {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("\n enter 'crypt' for encoding \n 'decrypt' for decoding\n");
		String getInput = input.next();
		System.out.println("please enter the sentence you want to decode or encode");
                String sentence = input.next();
		char[] words = sentence.toCharArray();
              	int lengthOfWords = words.length;
		System.out.println("enter the key");
		String keys = input.next();
		char[] key = keys.toCharArray();
		int lengthOfKey = key.length;
		char[] keyExtend = extendOrCutArray(lengthOfKey, lengthOfWords, key, words);
                int lengthOfKeyExtend = keyExtend.length;

		switch (getInput) {
			case "crypt":
               			char[] encrypted = encode(lengthOfWords, lengthOfKeyExtend, keyExtend, words);
        		        System.out.println("the encode of the sentence is :");
				printMethode(encrypted, lengthOfKeyExtend); 
				break;
			case "decrypt":
	          		char[] decrypted = decode(lengthOfWords, lengthOfKeyExtend, keyExtend, words);
				System.out.println("the decode is:");
				printMethode(decrypted, lengthOfKeyExtend);
				break;
			default:
				System.out.println("the invalid input \n please try again");
				break;
		}


	}
	/**
	 *this method decrypts the given word by subtracting the word and keyword 
	 * 
	 *
	 *@return  the decrypted word as an Array of char
	 *
	 *
	 *
	 */

	public static char[] decode(int lengthOfWords, int lengthOfKeyExtend, char[] keyExtend, char[] words) {
                int[] decode = new int[lengthOfKeyExtend];
		char[] decrypted = new char[lengthOfKeyExtend];
                for (int i = 0; i < lengthOfKeyExtend; i++) {
			decode[i] = (words[i] - keyExtend[i]);
			if (decode[i] < 0) {
				decrypted[i] = (char)(decode[i] + 128);
			} else {
				decrypted[i] = (char)decode[i];
			}
		}
		return decrypted;
        }



	/**this method prints the decrypted or encrypted word
	 * @*/

	public static void printMethode(char[] methode, int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(methode[i]);
		}
	}


	/**
	 * this method encodes the word by addig the given word to the keyword.
	 * @return  encrypted word as Array of character
	 */



	public static char[] encode(int lengthOfWords, int lengthOfKeyExtend, char[] keyExtend, char[] words) { 
		char[] encrypted = new char[lengthOfKeyExtend];	
		for (int i = 0; i < lengthOfKeyExtend; i++) {
			encrypted[i] = (char)(words[i] + keyExtend[i]);
			if (encrypted[i] > 128) {
				encrypted[i] = (char)(encrypted[i] % 128);
			} else encrypted[i] = (encrypted[i]);	
		}
		return encrypted;
	}

	/**
	 * this method extends or cuts the keyword in order to fit the length of given word.
	 * @param diffLengths the difference of length of the keyword and that given word.
	 * @param keyExtend the extended version of keyword.
	 * @param keyCut is the shortened version of the keyword.
	 * the way that this method works is that if the length of given word was longer than our keyword,
	 * and the difference between the word and keyword was also longer than key word, 
	 * it multiples the key word.
	 * but if the difference between the length of the word and keyword is not longer than our keyword. 
	 * it adds the rest alphabets to keyword.
	 * if the keyword is longer than word it cuts the keyword.
	 *
	 * @return the extended or shortened form of the key word.
	 *
	 */

	public static char[] extendOrCutArray(int lengthOfKey, int lengthOfWords, char[] key, char[] words) {
		int diffLengths = lengthOfWords - lengthOfKey;
		if (diffLengths > 0) {
			char[] keyExtend = Arrays.copyOf(key, diffLengths + lengthOfKey);
			if (diffLengths > lengthOfKey) {
				for (int i = 1; i <= (diffLengths / lengthOfKey); i++) {
					for (int x = 0; x < lengthOfKey; x++) {
						keyExtend[x + i * lengthOfKey] = key[x];
					}
				}
				for (int y = 0; y < (diffLengths % lengthOfKey); y++) {
					keyExtend[y + (diffLengths / lengthOfKey + 1) * lengthOfKey] = key[y];
				}
			}
			if (diffLengths <= lengthOfKey) {
				for (int i = lengthOfKey; i < lengthOfKey + diffLengths; i++) {
					keyExtend[i] = key[i - lengthOfKey];
				}
			}
			return keyExtend;
		}
		else {
			char[] keyCut = new char[lengthOfWords];
			for (int j = 0; j < lengthOfWords; j++) {
				keyCut[j] = key[j];
			}
			return keyCut;
		}
	}
}
