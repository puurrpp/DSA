public class LabEx4 {
	static java.util.Scanner sc = new java.util.Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Bernales, Gian");
		System.out.println("Mendoza, Kyran");
		System.out.println();

		System.out.print("Input t: ");
		int t = sc.nextInt();

		if (t == 1) {
			// build t0 (empty tree)
			BT t0 = new BT();

			t0.computeLevels();
			System.out.println(t0);
			System.out.println(); // spacer


			// build t1 (bottom-up)
			BTNode<Integer> four = new BTNode<>(4);
			BTNode<Integer> two = new BTNode<>(2);
			BTNode<Integer> one = new BTNode<>(1, null, two);
			BTNode<Integer> five = new BTNode<>(5, four, null);
			BTNode<Integer> three = new BTNode<>(3, one, five);
			BT t1 = new BT();
			t1.setRoot(three);

			t1.computeLevels();
			System.out.println(t1);
			System.out.println(); // spacer


			// build t2 (bottom-up)
			BT t2 = new BT();
			BTNode<String> e = new BTNode<>("E");
			BTNode<String> v = new BTNode<>("V", null, e);
			BTNode<String> z = new BTNode<>("Z");
			BTNode<String> f = new BTNode<>("F");
			BTNode<String> g = new BTNode<>("G");
			BTNode<String> d = new BTNode<>("D", f, g);
			BTNode<String> _t = new BTNode<>("T");
			BTNode<String> h = new BTNode<>("H", v, z);
			BTNode<String> a = new BTNode<>("A", d, null);
			BTNode<String> m = new BTNode<>("M", _t, null);
			BTNode<String> c = new BTNode<>("C", null, h);
			BTNode<String> x = new BTNode<>("X", a, m);
			BTNode<String> s = new BTNode<>("S", c, x);
			t2.setRoot(s);

			t2.computeLevels();
			System.out.println(t2);
		} else if (t == 2) {

		}
	}
}
