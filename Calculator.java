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
	private final Set<String> simples = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^", "rt", "%"));
	private final Set<String> functions = new HashSet<>(Arrays.asList("sin", "cos", "tan", "asin", "acos", "atan", "sq", "sqrt", "cbrt", "*%", "!", "log", "ln", "toDeg", "toRad"));
	private final Set<String> constants = new HashSet<>(Arrays.asList("e", "pi"));
	private Deque<Double> stack;
	private boolean radian;

	/**
	 * The Calculator constructor constructs the local stack based on a previously
	 * declared stack
	 * 
	 * @param input
	 */
	public Calculator(Deque<Double> inStack) {
		stack = inStack;
		radian = true;
	}

	/**
	 * The method scans what type of operation the input is
	 * 
	 * @param input
	 * @return boolean
	 */
	public boolean contains(String input) {
		return simples.contains(input) || functions.contains(input) || constants.contains(input);
	}

	/**
	 * Directs the input to simples or functions depending on what the input is
	 * 
	 * @param input
	 */
	public void calculate(String input) {
		if (simples.contains(input)) {
			simple(input);
		} else if (functions.contains(input)) {
			function(input);
		} else {
			constant(input);
		}
	}

	/**
	 * Pushes the user requested constant onto the stack, such as PI or E
	 * 
	 * @param input
	 */
	private void constant(String input) {
		switch (input) {
		case "e":
			stack.push(Math.E);
			break;
		case "pi":
			stack.push(Math.PI);
			break;
		}
	}

	/**
	 * Performs operations on the stack which requires the pop stack to be popped.
	 * 
	 * @param input
	 */
	private void function(String input) {
		if (stack.size() > 0) {
			double num = (double) stack.pop();
			double angle = num;
			if (!radian) {
				angle = Math.toRadians(num);
			}
			double ans = 0;
			switch (input) {
			case "sq":
				ans = num * num;
				break;
			case "sin":
				ans = Math.sin(angle);
				break;
			case "cos":
				ans = Math.cos(angle);
				break;
			case "tan":
				ans = Math.tan(angle);
				break;
			case "asin":
				ans = Math.asin(num);
				break;
			case "acos":
				ans = Math.acos(num);
				break;
			case "atan":
				ans = Math.atan(num);
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
			case "!":
				ans = 1;
				for (double i = num; i > 0; i -= 1) {
					ans *= i;
				}
				break;
			case "log":
				ans = Math.log10(num);
				break;
			case "ln":
				ans = Math.log(num);
				break;
			case "toDeg":
				ans = Math.toDegrees(num);
				break;
			case "toRad":
				ans = Math.toRadians(num);
				break;
			}
			if ((input.equals("asin") || input.equals("acos") || input.equals("atan")) && !radian) {
				stack.push(Math.toDegrees(ans));
			} else {
				stack.push(ans);
			}
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}

	/**
	 * The method executes basic operations such as +, -, *, and /. All of the
	 * operations here will require at least two numbers to be popped off the stack
	 * 
	 * @param input
	 */
	private void simple(String input) {
		if (this.stack.size() > 1) {
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
	/**
	 * Updates the radian or degree option for the Calculator; true = radian; false = degree.
	 * @param isRadian
	 */
	public void setAngle(boolean isRadian) {
		radian = isRadian;
	}
}
