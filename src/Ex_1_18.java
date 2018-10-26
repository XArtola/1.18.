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

		// String preference[] =
		// {"t","a","o","i","s","w","c","b","p","h","f","m","d","r","e","l","g","u","v","y","j","k","q","x","z"};//

		String order[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z" };

		String result[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
				" ", " ", " ", " ", " ", " ", " ", " "};
		String incompatible = " ";

		while (finishFlag) {
			
			System.out.println("Enter as many words as you want to order them alphabetically");

			String words[] = sc.nextLine().split(" ");

			for (int i = 0; words.length - 1 >= i; i++) {

				compare :for (int j = 0; order.length - 1 >= j; j++) {
					
					if(words[i].matches("[^[A-Za-z]$/]")) {
						
						incompatible= " " + words[i];
						break compare;						
					}
					else if (words[i].charAt(0) == order[j].charAt(0)) {
						if (result[j] == " ") {
							result[j] = words[i];						
							break compare;

						}

						else {

							result[j] = result[j] + " " + words[i];

						}

					}
					
					}

				}

			

			System.out.println("The correct order is:\n");
			for (int k = 0; result.length > k; k++) {

				if (result[k] != " ") {

					System.out.println(result[k]);

				}

			}
			
			System.out.println("\n" + "Wrong or imcompatible: " + incompatible + "\n");

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
					
					for(int k = 0; k > result.length; k++ ) {
						
						/*result[k] = null;*/
						
					}

				}

				else {

					System.out.println("You have not entered a valid option. TRY AGAIN.\n");
					
				}

			}
		}

	}

}
