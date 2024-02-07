// Mendoza, Kyran Xandre O. & Teneza, Lawrence Patrick P.
// ICS2605 1CSA
// Lab Exercise 1 Part 1


import java.util.Scanner;

public class LabEx1 {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Mendoza, Kyran Xandre O.");
		System.out.println("Teneza, Lawrence Patrick P.");

		System.out.println();

		System.out.print("Input a positive integer t: ");
		int t = s.nextInt();
		System.out.print("Input a positive integer n: ");
		int n = s.nextInt();

		long start, end;
		long ans;

		if (t < 1 || t > 2)
			return;

		if (t == 1) {
			start = System.nanoTime();
			ans = fib(n);
			end = System.nanoTime();
		} else {
			start = System.nanoTime();
			ans = fibR(n);
			end = System.nanoTime();
		}


		System.out.println("call fib" + (t == 2 ? "R" : "") + "(int n) with arg " + n);
		System.out.println("return value = " + ans);
		System.out.printf("elapsed time: %,.3f ms", (end - start) / 1000.0);
	}

	static long fib(int n) {
		if (n == 0 || n == 1)
			return n;

		int pprev, prev = 0, curr = 1;
		for (int i = 0; i < n; i++) {
			pprev = prev;
			prev = curr;
			curr += pprev;
		}

		return curr;
	}

	static long fibR(int n) {
		if (n == 0 || n == 1)
			return n;

		return fibR(n - 1) + fibR(n - 2);
	}
}
