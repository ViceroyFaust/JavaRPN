package owl;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
	private final static Set<String> simples = new HashSet<>(Arrays.asList("+", "-", "*", "/", "^"));
	private final static Set<String> functions = new HashSet<>(Arrays.asList("sin", "cos", "tan", "asin", "acos", "atan", "sq"));
	private static Deque<Double> stack;
	
	public Calculator(Deque<Double> stack) {
		Calculator.stack = stack;
	}

	public boolean contains(String input) {
        return simples.contains(input) || functions.contains(input);
    }

    public void calculate(String input) {
        if (simples.contains(input)) {
            simple(input);
        } else {
            function(input);
        }
    }

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
			}
			stack.push(ans);
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}
	
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
			}
			stack.push(ans);
		} else
			System.out.println("ERROR: can't operate on empty stack");
	}

}
