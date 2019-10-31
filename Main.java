package owl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Stack<Double> stack = new Stack<Double>();
		System.out.println("JavaRPN: Input numbers and operands separated by newline or space");
		while (true) {
			try {
				String input = reader.readLine().toLowerCase();
				RPNcli.parse(input, stack);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
