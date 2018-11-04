
/**
 * @author Xabier
 *
 */
import java.util.Arrays;
import java.util.Scanner;

public class Ex_1_18 {

	/**
	 * @param args
	 */
	public static String[] toOrder(String words) {

		words = words.trim();
		String separatedWords[] = words.split(" ");

		int dismissedCnt = 0;

		String dismissed = " ";

		for (int a = 0; separatedWords.length - 1 - dismissedCnt >= a; a++) {

			filter: while (!(separatedWords[a].matches("^[a-zA-Z]+"))) {

				dismissed += separatedWords[a] + "/";

				dismissedCnt++;

				for (int b = a; separatedWords.length - 1 > b; b++) {

					separatedWords[b] = separatedWords[b + 1];
					separatedWords[b + 1] = " ";
				}

				if (dismissedCnt + a > separatedWords.length - 1) {
					break filter;
				}

			}
		}

		dismissed = dismissed.trim();

		int usefullArray = separatedWords.length - 1 - dismissedCnt;

		String correctOrder = " ";
		int smallestWordIndex = 0;

		while (usefullArray > 0) {

			for (int c = 0; usefullArray >= c; c++) {

				if (separatedWords[smallestWordIndex].compareTo(separatedWords[c]) > 0) {

					smallestWordIndex = c;
				}

			}

			correctOrder += "/" + separatedWords[smallestWordIndex];
			correctOrder = correctOrder.trim();
			System.out.println(correctOrder);
			for (int d = smallestWordIndex; usefullArray > d; d++) {

				separatedWords[d] = separatedWords[d + 1];
				separatedWords[d + 1] = "/";

			}
			System.out.println(Arrays.toString(separatedWords));
			usefullArray--;
			smallestWordIndex = 0;
		}

		correctOrder += "/" + separatedWords[0];
		separatedWords[0] = "/";
		System.out.println("order" + correctOrder);
		String result[] = new String[2];

		result[0] = correctOrder;
		result[1] = dismissed;

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		boolean finish = false;
		while (!finish) {

			System.out.println("Enter as many words as you want to order them alphabetically.\n"
					+ "Words containing non letter characters are going to be dismissed");

			String sentence = sc.nextLine();
			
			sentence = sentence.toLowerCase().trim();
			System.out.println(sentence);

			String toPrint[] = new String[2];

			toPrint = toOrder(sentence);

			System.out.println("The correct order of the words you have entered is:\n" + toPrint[0]);
			System.out.println("The dismissed words are:\n" + toPrint[1]);
			
			boolean validOption = false;

			while (!validOption) {
				System.out.println("Do you want to continue? [y/n]\n");
				String fin = sc.next().toLowerCase();
				sc.nextLine();
				if (fin.substring(0, 1).matches("y")) {
					validOption = true;
				} else if (fin.substring(0, 1).matches("n")) {
					validOption = true;
					finish = true;
				} else {

					System.out.println("This is not an option. Try again. \n");

				}
			}

		}

	}

}
