package april0418;

public class IfArgsTest {
	public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("exactly one integer argment must be specified");
            return;
        }

		int x = Integer.parseInt(args[0]);
		/*以下を改造する。**/

        if (1 <= x && x <= 3) {
            System.out.println(x + " is a small number");
        } else if (4 <= x && x <= 6) {
            System.out.println(x + " is a middle number");
        } else if (7 <= x && x <= 9) {
            System.out.println(x + " is a big number");
        } else {
            System.out.println(x + " is out of range");
        }

	}//main end
}//class end
