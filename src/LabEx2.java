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

				switch (op) {
					case "+" -> stuff.push(String.valueOf(a + b));
					case "-" -> stuff.push(String.valueOf(a - b));
					case "*" -> stuff.push(String.valueOf(a * b));
					case "/" -> stuff.push(String.valueOf(a / b));
					case "%" -> stuff.push(String.valueOf(a % b));
					case "^" -> stuff.push(String.valueOf(Math.pow(a, b)));
				}
			} else {
				stuff.push(op);
			}
		}

		return Double.parseDouble(stuff.pop());
	}

	static int inStackPrecedence(String op) {
		switch (op) {
			case "+", "-" -> {
				return 10;
			}
			case "%" -> {
				return 20;
			}
			case "*", "/" -> {
				return 30;
			}
			case "^" -> {
				return 40;
			}
			case "(" -> {
				return 50;
			}
			default -> {
				return -1;
			}
		}
	}

	static int incomingPrecedence(String op) {
		switch (op) {
			case "+", "-" -> {
				return 10;
			}
			case "%" -> {
				return 20;
			}
			case "*", "/" -> {
				return 30;
			}
			case "^" -> {
				return 45;
			}
			case "(" -> {
				return 55;
			}
			default -> {
				return -1;
			}
		}
	}


	static String infixToPostfix(String e) {
		String[] ops = e.split(" ");
		Stack<String> stack = new Stack<>();
		StringBuilder output = new StringBuilder();

		for (String op : ops) {
			// operand
			if (!"+-%*/^()".contains(op))
				output.append(op).append(" ");

			// operators
			else if (stack.isEmpty() || stack.peek().equals("(")) {
				stack.push(op);

			} else if (op.equals(")")) {
				while (!stack.peek().equals("("))
					output.append(stack.pop()).append(" ");
				stack.pop();

			} else if (incomingPrecedence(op) > inStackPrecedence(stack.peek())) {
				stack.push(op);

			} else {
				while (!stack.isEmpty() && (incomingPrecedence(op) <= inStackPrecedence(stack.peek())))
					output.append(stack.pop()).append(" ");
				stack.push(op);
			}
		}

		while (!stack.isEmpty()) {
			output.append(stack.pop()).append(" ");
		}
		return output.toString().trim();
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
			System.out.println("value: " + evalPostfix(s));
		} else if (t == 2) {
			System.out.println("infix: " + s);
			System.out.println("postfix: " + infixToPostfix(s));
			System.out.println("value: " + evalPostfix(infixToPostfix(s)));
		}
	}

}