// Mendoza, Kyran Xandre O.
// ICS2605 1CSA
// Lab Exercise 3


import java.util.Scanner;
public class LabEx3 {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Mendoza, Kyran Xandre O.");
		System.out.println();

		System.out.print("Input t: ");
		int t = scanner.nextInt();
		if (t == 1) {
			System.out.print("Input s (number of syllables): ");
			int s = scanner.nextInt();
			System.out.print("Input n (number of children): ");
			int n = scanner.nextInt();

			Queue<String> queue = new Queue<>();
			char c = 'A';
			for (int i=0; i < n; i++)
				queue.enqueue(String.valueOf(c++));

			System.out.println(queue);
		}
	}
}
