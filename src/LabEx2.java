// Bihasa, Christian Louie A. & Mendoza, Kyran Xandre O.
// ICS2605 1CSA
// Lab Exercise 2 Part 1

import java.util.Scanner;

public class LabEx2 {
	static Scanner scanner = new Scanner(System.in);

	static String postfixToInfix(String e) {

		String[] ops = e.split(" ");

		Stack<String> stuff = new Stack<>(ops.length);

		for (String op : ops) {
			if ("+-*/%^".contains(op)) {
				String b = stuff.pop();
				String a = stuff.pop();

				stuff.push("(" + a + " " + op + " " + b + ")");
			} else {
				stuff.push(op);
			}
		}

		StringBuilder output = new StringBuilder();

		while (!stuff.isEmpty())
			output.append(stuff.pop());

		return output.toString();
	}

	static double evalPostfix(String e) {
		String[] ops = e.split(" ");

		Stack<String> stuff = new Stack<>(ops.length);

		for (String op : ops) {
			if ("+-*/%^".contains(op)) {
				double b = Double.parseDouble(stuff.pop());
				double a = Double.parseDouble(stuff.pop());

				switch (op.charAt(0)) {
					case '+' -> stuff.push(String.valueOf(a + b));
					case '-' -> stuff.push(String.valueOf(a - b));
					case '*' -> stuff.push(String.valueOf(a * b));
					case '/' -> stuff.push(String.valueOf(a / b));
					case '%' -> stuff.push(String.valueOf(a % b));
					case '^' -> stuff.push(String.valueOf(Math.pow(a, b)));
				}
			} else {
				stuff.push(op);
			}
		}

		return Double.parseDouble(stuff.pop());
	}

	public static void main(String[] args) {
		System.out.println("Bihasa, Christian Louie A.");
		System.out.println("Mendoza, Kyran Xandre O.");
		System.out.println();

		System.out.print("Input t: ");
		int t = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Input s: ");
		String s = scanner.nextLine();
		System.out.println();

		if (t == 1) {
			System.out.println("postfix: " + s);
			System.out.println("infix: " + postfixToInfix(s));
			System.out.println("eval: " + evalPostfix(s));
		}
	}

}