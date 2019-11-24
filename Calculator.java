package owl;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Calculator is responsible for executing operations and functions, pushing
 * resulting values to the stack
 * 
 * @author D. F. Owl
 */

public class Calculator {
	private final static Set<String> simples = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^", "rt", "%"));
	private final static Set<String> functions = new HashSet<>(Arrays.asList("sin", "cos", "tan", "asin", "acos", "atan", "sq", "sqrt", "cbrt", "*%"));
	private static Deque<Double> stack;

	/**
	 * The Calculator constructor constructs the local stack based on a previously
	 * declared stack
	 * 
	 * @param stack
	 */
	public Calculator(Deque<Double> stack) {
		Calculator.stack = stack;
	}

	/**
	 * The method scans what type of operation the input is
	 * 
	 * @param input
	 * @return boolean
	 */
	public boolean contains(String input) {
		return simples.contains(input) || functions.contains(input);
	}

	/**
	 * Directs the input to simples or functions depending on what the input is
	 * 
	 * @param input
	 */
	public void calculate(String input) {
		if (simples.contains(input)) {
			simple(input);
		} else {
			function(input);
		}
	}

	/**
	 * Performs operations on the stack which requires the pop stack to be popped.
	 * 
	 * @param input
	 */
	private static void function(String input) {
		if (stack.size() > 0) {
			double num = (double) stack.pop();
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
			case "sqrt":
				ans = Math.sqrt(num);
				break;
			case "cbrt":
				ans = Math.cbrt(num);
				break;
			case "*%":
				ans = num * 100;
				break;
			}
			stack.push(ans);
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}

	/**
	 * The method executes basic operations such as +, -, *, and /. All of the
	 * operations here will require at least two numbers to be popped off the stack
	 * 
	 * @param input
	 */
	private static void simple(String input) {
		if (stack.size() > 1) {
			double num2 = (double) stack.pop();
			double num1 = (double) stack.pop();
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
			case "rt":
				ans = Math.pow(num1, (1.0 / num2));
				break;
			case "%":
				ans = num1 % num2;
				break;
			}
			stack.push(ans);
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}

}
