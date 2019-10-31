package owl;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RPNcli {

	public static void parse(String input, Stack<Double> stack) {
		String[] parts = input.split(" ");
		for (int i = 0; i < parts.length; i++) {
			Double num = isNumber(parts[i]);
			if (num != null) {
				stack.push(num);
			} else
				operation(parts[i], stack);
		}
	}

	private static void operation(String input, Stack<Double> stack) {
		Set<String> simples = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^"));
		Set<String> functions = new HashSet<>(Arrays.asList("sin", "cos", "tan", "asin", "acos", "atan", "sq"));
		Set<String> commands = new HashSet<>(Arrays.asList("p", "e", "c", "pop", "swap"));
		if (simples.contains(input)) {
			simple(input, stack);
		} else if (functions.contains(input)) {
			function(input, stack);
		} else if (commands.contains(input)) {
			command(input, stack);
		} else {
			System.out.println("ERROR: Invalid Command");
		}
	}

	private static void command(String input, Stack<Double> stack) {
		DecimalFormat df = new DecimalFormat("#,###.#########");
		switch (input) {
		case "e":
			System.exit(0);
			break;
		case "p":
			if (stack.size() > 0) {
				System.out.println(df.format(stack.peek()));
			} else
				System.out.println("ERROR: no stacks to peek");
			break;
		case "c":
			stack.clear();
			break;
		case "pop":
			if (stack.size() > 0) {
				stack.pop();
			} else
				System.out.println("ERROR: no stacks to pop");
			break;
		case "swap":
			if (stack.size() > 1) {
				double num2 = stack.pop();
				double num1 = stack.pop();
				stack.push(num2);
				stack.push(num1);
			} else
				System.out.println("ERROR: can't swap empty stack");
		}

	}

	private static void function(String input, Stack<Double> stack) {
		if (stack.size() > 0) {
			double num = stack.pop();
			double rads = Math.toRadians(num);
			double ans = 0;
			switch (input) {
			case "sq":
				ans = num * num;
				break;
			case "sin":
				ans = Math.sin(rads);
				break;
			case "cos":
				ans = Math.cos(rads);
				break;
			case "tan":
				ans = Math.tan(rads);
				break;
			case "asin":
				ans = Math.toDegrees(Math.asin(num));
				break;
			case "acos":
				ans = Math.toDegrees(Math.acos(num));
				break;
			case "atan":
				ans = Math.toDegrees(Math.atan(num));
				break;
			}
			stack.push(ans);
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}

	private static void simple(String input, Stack<Double> stack) {
		if (stack.size() > 1) {
			double num2 = stack.pop();
			double num1 = stack.pop();
			double ans = 0;
			switch (input) {
			case "+":
				ans = num1 + num2;
				break;
			case "-":
				ans = num1 - num2;
				break;
			case "*":
				ans = num1 * num2;
				break;
			case "/":
				ans = num1 / num2;
				break;
			case "^":
				ans = Math.pow(num1, num2);
				break;
			}
			stack.push(ans);
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}

	private static Double isNumber(String input) {
		try {
			double num = Double.parseDouble(input);
			return num;
		} catch (NumberFormatException n) {
			return null;
		}
	}
}
