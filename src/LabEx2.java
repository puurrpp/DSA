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

	static String infixToPostfix(String e) {
		String[] ops = e.split(" ");
		Stack<String> stack = new Stack<>();
		StringBuilder output = new StringBuilder();
		for (String op : ops) {
			switch (op) {
				case "+":
				case "-":
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						output.append(stack.pop()).append(" ");
					}
					stack.push(op);
					break;
				case "*":
				case "/":
				case "%":
					while (!stack.isEmpty() && (stack.peek().equals("*") || stack.peek().equals("/") || stack.peek().equals("%"))) {
						output.append(stack.pop()).append(" ");
					}
					stack.push(op);
					break;
				case "^":
					while (!stack.isEmpty() && stack.peek().equals("^")) {
						output.append(stack.pop()).append(" ");
					}
					stack.push(op);
					break;
				case "(":
					stack.push(op);
					break;
				case ")":
					while (!stack.isEmpty() && !stack.peek().equals("(")) {
						output.append(stack.pop()).append(" ");
					}
					stack.pop();
					break;
				default:
					output.append(op).append(" ");
					break;
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
			System.out.println("eval: " + evalPostfix(s));
		} else if (t == 2) {
			System.out.println("infix: " + s);
			System.out.println("postfix: " + infixToPostfix(s));
			System.out.println("eval: " + evalPostfix(infixToPostfix(s)));
		}
	}

}