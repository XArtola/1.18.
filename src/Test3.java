/**
 * 
 */

/**
 * @author Xabier
 *
 */
import java.util.Scanner;


public class Test3 {

	/**
	 * @param args
	 */
	public static int wordsValue(String word) {
		
		String order[] = {" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" }; // length 26
		int wordValue = 0;
		
			for (int h =0; word.length() > h; h++) {
				
				for (int j = 0; order.length > j; j++ ) {
					
					if(word.substring(h,h+1).equals(order[j])) {
						
						wordValue += j; 
						
					}
				}
			}
			
			return wordValue;
		}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean finishFlag = true;

		

		String incompatible = " ";

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

			int values[] = new int[words.length];

			int cntwords = 0;
			int cntpos = 0;

			for (int a = 0; words.length > a; a++) {
				

				cntpos = 0;
				for (int b = 0; words[cntwords].length() >= b; b++) {
					
					

					sumatory: if (!(words[cntwords] == " ")) {

						/*System.out.println(words[cntwords].charAt(cntpos)); //PRINT*/
						
						values[cntwords]=wordsValue(words[cntwords]);
						
						System.out.println(values[cntwords]);

						/*char letter = words[cntwords].charAt(cntpos);

						switch (letter) {

						case 'a':
							wordcnt += 1;

							break ;

						case 'b':
							wordcnt += 2;

							break sumatory;

						case 'c':
							wordcnt += 3;

							break sumatory;

						case 'd':
							wordcnt += 4;

							break sumatory;

						case 'e':
							wordcnt += 5;

							break sumatory;

						case 'f':
							wordcnt += 6;

							break sumatory;

						case 'g':
							wordcnt += 7;

							break sumatory;

						case 'h':
							wordcnt += 8;

							break sumatory;

						case 'i':
							wordcnt += 9;

							break sumatory;

						case 'j':
							wordcnt += 10;

							break sumatory;

						case 'k':
							wordcnt += 11;

							break sumatory;

						case 'l':
							wordcnt += 12;

							break sumatory;

						case 'm':
							wordcnt += 13;

							break sumatory;

						case 'n':
							wordcnt += 14;

							break sumatory;

						case 'o':
							wordcnt += 15;

							break sumatory;

						case 'p':
							wordcnt += 16;

							break sumatory;

						case 'q':
							wordcnt = 17;

							break sumatory;

						case 'r':
							wordcnt = 18;

							break sumatory;

						case 's':
							wordcnt += 19;

							break sumatory;

						case 't':
							wordcnt += 20;

							break sumatory;

						case 'u':
							wordcnt += 21;

							break sumatory;

						case 'v':
							wordcnt = +22;

							break sumatory;

						case 'w':
							wordcnt += 23;

							break sumatory;

						case 'x':
							wordcnt += 24;

							break sumatory;

						case 'y':
							wordcnt += 25;

							break sumatory;

						case 'z':
							wordcnt += 26;

							break sumatory;

						default:
							System.out.println("ERROR");

							break sumatory;
						}*/

					}

					else {

						values[a] = 0;

					}

					cntpos++;
					
					
				}
				
				values[cntwords] = wordcnt;
				
				System.out.println(values[cntwords]);
				
				wordcnt = 0;

				cntwords++;

			}

			for (int d = 0; words.length - 1 > d; d++) {

				int maxVal = values[0];
				int maxValIndex = 0;

				for (int e = 0; words.length - 1 > e; e++) {

					if (maxVal < values[d]) {

						maxVal = values[d];

						maxValIndex = d;
					}

				}

				System.out.println(words[maxValIndex]);

				values[maxValIndex] = 0;

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

				}

				else {

					System.out.println("You have not entered a valid option. TRY AGAIN.\n");

				}

			}

		}

	}

}