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

			System.out.print("children: ");
			KQueue<String> children = new KQueue<>(n);
			char c = 'A';
			for (int i = 0; i < n; i++) {
				System.out.print(c + " ");
				children.enqueue(String.valueOf(c++));
			}
			System.out.println();

			// game start
			KStack<String> winners = new KStack<>(n);

			// rounds loop:
			for (int i = 1; i <= n; i++) {

				// intentionally leave last step out of loop
				for (int j = 1; j < s; j++)
					children.enqueue(children.dequeue());
				// eliminate 1 child
				winners.push(children.dequeue());

				System.out.print("after round " + i + ": ");
				// print survivors
				if (children.isEmpty())
					System.out.print("Empty");
				else
					for (int j = 0; j < children.count; j++) {
						String child = children.dequeue();
						System.out.print(child + " ");
						children.enqueue(child);
					}

				// fix spacing
				System.out.println();
			}

			System.out.print("winning order: ");
			while (!winners.isEmpty())
				System.out.print(winners.pop() + " ");

			// System.out.println(children.debug());

		} else if (t == 2) {
			System.out.print("Input s: ");
			String[] inputs = scanner.nextLine().split(" ");

			
		}
	}
}
