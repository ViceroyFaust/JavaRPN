package owl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			Stack<Double> stack = new Stack<Double>();
			System.out.println("JavaRPN: Input numbers and operands separated by newline or space");
			DecimalFormat df = new DecimalFormat("#,###.#########");
			while (true) {
				String input = reader.readLine();
				String[] inputs = input.split(" ");
				for (int i = 0; i < inputs.length; i++) {
					if (isNumber(inputs[i])) {
						stack.push(Double.parseDouble(inputs[i]));
						continue;
					}
					if (inputs[i].equals("e") || inputs[i].equals("p") || inputs[i].equals("c")) {
						commands(inputs[i], stack, df);
					} else if (inputs[i].equals("sq") || inputs[i].equals("sin") || inputs[i].equals("cos")
							|| inputs[i].equals("tan") || inputs[i].equals("asin") || inputs[i].equals("acos")
							|| inputs[i].equals("atan")) {
						function(inputs[i], stack);
					} else if (inputs[i].equals("+") || inputs[i].equals("-") || inputs[i].equals("*")
							|| inputs[i].equals("/") || inputs[i].equals("^")) {
						operator(stack, inputs[i]);
					} else {
						System.out.println("ERROR: Invalid input");
					}
				}
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	private static void commands(String input, Stack<Double> stack, DecimalFormat df) {
		switch (input) {
		case "e":
			System.exit(0);
			;
			break;
		case "p":
			if (stack.size() > 0) {
				System.out.println(df.format(stack.peek()));
				break;
			} else {
				System.out.println("ERROR: All Stacks Empty");
				break;
			}
		case "c":
			stack.clear();
			break;
		}

	}

	private static void function(String string, Stack<Double> stack) {
		if (stack.size() > 0) {
			double num = stack.pop();
			switch (string) {
			case "sq":
				stack.push(num * num);
				break;
			case "sin":
				stack.push(Math.sin(Math.toRadians(num)));
				break;
			case "cos":
				stack.push(Math.cos(Math.toRadians(num)));
				break;
			case "tan":
				stack.push(Math.tan(Math.toRadians(num)));
				break;
			case "asin":
				stack.push(Math.asin(Math.toRadians(num)));
				break;
			case "acos":
				stack.push(Math.acos(Math.toRadians(num)));
				break;
			case "atan":
				stack.push(Math.atan(Math.toRadians(num)));
				break;
			}
		}
	}

	private static void operator(Stack<Double> stack, String input) {
		if (stack.size() > 1) {
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
				break;
			case "^":
				stack.push(Math.pow(num1, num2));
				break;
			}
		} else {
			System.out.println("ERROR: Can't operate on an empty stack");
		}
	}

	private static boolean isNumber(String input) {
		try {
			Double.parseDouble(input);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
