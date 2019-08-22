package owl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Stack<Double> stack = new Stack<Double>();
			System.out.println("JavaRPN: Input numbers and operands separated by newline");
			while (true) {
				String input = reader.readLine();
				if (input.equals("e")) {
					break;
				}
				String[] inputs = input.split(" ");
				for (int i = 0; i < inputs.length; i++) {
					if (isNumber(inputs[i])) {
						stack.push(Double.parseDouble(inputs[i]));
					} else if (inputs[i].equals("p")) {
						System.out.println(stack.peek());
					} else {
						operator (stack, inputs[i]);
					}

				}
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void operator(Stack<Double> stack, String input) {
		double num2 = stack.pop();
		double num1 = stack.pop();
		switch (input) {
		case "+":
			stack.push(num1 + num2);
			break;
		case "-":
			stack.push(num1 - num2);
			break;
		case "*":
			stack.push(num1 * num2);
			break;
		case "/":
			stack.push(num1 / num2);
		case "s":
			stack.push(num1);
			stack.push(num2 * num2);
			break;
		}
	}

	private static boolean isNumber(String input) {
		if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("p") || input.equals("s")){
			return false;
		}
		return true;
	}

}
