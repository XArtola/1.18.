/**
 * 
 */

/**
 * @author Xabier
 *
 */
import java.util.Scanner;

public class Test4 {

	/**
	 * @param args
	 */
	public static String wordsValue(String word) {

		String order[] = { " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z" }; // length 26
		String wordValue = " ";

		for (int h = 0; word.length() > h; h++) {

			for (int j = 0; order.length > j; j++) {

				if (word.substring(h, h + 1).equals(order[j])) {

					wordValue +=" "+ j;

				}
			}
		}
		
		System.out.println(wordValue);
		wordValue.trim();
		return wordValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean finishFlag = true;

		String incompatible = " ";
		
		String result = " ";

		int wordcnt = 0;

		while (finishFlag) {

			System.out.println("Enter as many words as you want to order them alphabetically\n"
					+ "WARNING: Any word starting or containig a non letter will not be taken into consideration\n");

			String sentence = sc.nextLine().toLowerCase();
			sentence.trim();
			String words[] = sentence.split(" ");

			// Filter the token that are no words

			for (int i = 0; words.length - 1 >= i; i++) {

				words[i].trim();

				if (!(words[i].matches("[a-zA-Z]+"))) {

					incompatible += " " + words[i];

					words[i] = " ";

					break;
				}

			}

			String values[] = new String[words.length];

			int cntwords = 0;
			int cntpos = 0;

			for (int a = 0; words.length > a; a++) {

				cntpos = 0;

				if (!(words[cntwords] == " ")) {

					values[cntwords] = wordsValue(words[cntwords]);

					System.out.println(values[cntwords]);

				}

				else {

					values[cntwords] = " ";

				}

				cntwords++;

			}
			
			

			/*for (int d = 0; words.length - 1 >= d; d++) {

				int maxVal = values[0];
				int maxValIndex = 0;

				for (int e = 0; words.length - 1 > e; e++) {

					if (maxVal < values[d]) {

						maxVal = values[d];

						maxValIndex = d;
					}

				}
				
				result = words[maxValIndex] + "\n" + result;
				
				System.out.println(result);
				
				words[maxValIndex] = " ";

				values[maxValIndex] = 0;

			}*/
			
			
			System.out.println(result);
			result = " ";

			System.out.println("Wrong or imcompatible: " + incompatible + "\n");

			incompatible = " ";

			boolean optionFlag = true;

			while (optionFlag) {

				System.out.println("Do you want to continue? [y/n]\n");

				String election = sc.next();

				if (election.charAt(0) == 'n' || election.charAt(0) == 'N') {

					finishFlag = false;
					optionFlag = false;

				}

				else if (election.charAt(0) == 'y' || election.charAt(0) == 'Y') {

					optionFlag = false;
					sc.nextLine();

				}

				else {

					System.out.println("You have not entered a valid option. TRY AGAIN.\n");

				}

			}

		}

	}

}