package owl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		try {
			boolean exit = false;
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Stack<Double> stack = new Stack<Double>();
			System.out.println("JavaRPN: Input numbers and operands separated by newline or space");
			while (!exit) {
				String input = reader.readLine();
				String[] inputs = input.split(" ");
				for (int i = 0; i < inputs.length; i++) {
					if (inputs[i].equals("e")) {
						exit = true;
						break;
					}
					if (isNumber(inputs[i])) {
						stack.push(Double.parseDouble(inputs[i]));
						continue;
					} else if (isFunction(inputs[i])) {
						function(inputs[i], stack);
						continue;
					}

					else {
						operator(stack, inputs[i]);
					}

				}
			}

			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void function(String string, Stack<Double> stack) {
		switch (string) {
		case "p":
			System.out.println(stack.peek());
			break;
		case "s":
			double num = stack.pop();
			stack.push(num * num);
			break;
		}

	}

	private static boolean isFunction(String input) {
		if (input.equals("p") || input.equals("s")) {
			return true;
		}
		return false;
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
		}
	}

	private static boolean isNumber(String input) {
		if (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("p")
				|| input.equals("s")) {
			return false;
		}
		return true;
	}

}
