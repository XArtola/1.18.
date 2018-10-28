/**
 * 
 */

/**
 * @author ik013043z1
 *
 */
import java.util.Scanner;

public class Ex_1_18 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean finishFlag = true;

		String incompatible = " ";

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

					words[i] = "/";

					break;
				}

			}

			String minWord = " ";
			String index = "/";
			int repeat = 0;
			int minWordIndex = 0;
			int comparation = 0;
			int minpos = 0;

			int comparePos = 0;

			boolean finish = false;

			for (int a = 0; words.length - 1 >= a; a++) {

				if (words[comparePos].matches("/")) {

					comparePos++;
				}

				minWord = words[comparePos];
				minWordIndex = comparePos;

				if (!(words[comparePos].matches("/"))) {

					for (int b = 0; words.length - 1 >= b; b++) {

						if (!(comparePos == b)) {

							if (!(words[b].matches("/"))) {

								if (minWord.compareTo(words[b]) == 0) {
									repeat = b;

								}

								else if (minWord.compareTo(words[b]) > 0) {
									minWord = words[b];
									minWordIndex = b;

								}

							}
						}
					}

					if (index.matches("/")) {

						index = minWord;
						words[minWordIndex] = "/";

					}

					else {

						index += " " + minWord;
						words[minWordIndex] = "/";

					}

				}
			}

			System.out.println("The correct order is: " + index);

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