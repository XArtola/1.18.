/**
 * 
 */

/**
 * @author Xabier
 *
 */
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean finishFlag = true;

		String order[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" }; //26

		String result[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
				" ", " ", " ", " ", " ", " ", " ", " " };//26
		String incompatible = " ";

		int cuantity[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };//26

		int pos;

		while (finishFlag) {

			pos = 0;

			System.out.println("Enter as many words as you want to order them alphabetically\n"
					+ "WARNING: Any word starting or containig a non letter will not be taken into consideration\n");

			
			String sentence =sc.nextLine().toLowerCase();
			String words[] = sentence.split(" ");
			

			boolean unordered = true;

			while (unordered) {

				unordered = false;

				// Filter the token that are no words

				for (int i = 0; words.length - 1 >= i; i++) {

					filter: for (int j = 0; order.length - 1 >= j; j++) {

						words[i].trim();

						if (!(words[i].matches("[a-zA-Z]+"))) {

							incompatible += " " + words[i];

							words[i] = " ";

							break filter;
						}

					}

				}

				// Prueba

				System.out.println(incompatible);

				// Prueba

				for (int a = 0; words.length-1 >a; a++) {

					if (!(words[a] == " ")) {

						count: for (int b = 0; order.length - 1 >= b; b++) {
							
							
							if (words[a].charAt(pos) == order[b].charAt(0)) {

								cuantity[b]++;

								System.out.println(cuantity[b]);

								break count;

							}
						}

					}
				}

				for (int l = 0;  words.length-1 >= l; l++) {

					if (!(words[l] == " ")) {

						index: for (int m = 0; order.length-1>= m; m++) {
							
							System.out.println(words[l].charAt(pos) == order[m].charAt(0));


							if (words[l].charAt(pos) == order[m].charAt(0)) {

								if (cuantity[m] == 1) {

									for (int n = 0; order.length - 1 >= n; n++) {

										if (words[l].charAt(0) == order[n].charAt(0)) {

											if (result[n] == " ") {

												result[n] = words[l];

												words[l] = " ";

												cuantity[m] = 0;

												break index;

											}

											else {

												result[n] = result[n] + " " + words[l];

												words[l] = " ";

												result[n].trim();

												cuantity[m] = 0;

												break index;

											}
										}

									}

								}
								
								else {
									cuantity[m] = 0;
									
								}

							}

						}

					}

				}

				for (int o = 0; words.length - 1 >= o; o++) {

					if (!(words[o] == " ")) {

						unordered = true;
						
						pos++;

					}

				}

			}

			// Dauden hitz guztien bigarren letra hartu eta indexeko posizioa gorde,
			// konparatu eta horren arabera array-ean sartu

			System.out.println("The correct order is:\n");
			for (int k = 0; result.length - 1 >= k; k++) {

				if (result[k] != " ") {

					System.out.println(result[k]);

					result[k] = " ";

				}

			}

			System.out.println("\n" + "Wrong or imcompatible: " + incompatible + "\n");
			
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

					for (int k = 0; k > result.length - 1; k++) {

					}

				}

				else {

					System.out.println("You have not entered a valid option. TRY AGAIN.\n");

				}

			}
		}

	}

}
