package owl;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Deque;

/**
 * The RPNcli Object is responsible for parsing the CLI input and for executing
 * commands. Number operations are passed down to the Calculator object.
 * 
 * @author D. F. Owl
 */
public class RPNcli {
	private final Set<String> commands = new HashSet<>(Arrays.asList("p", "exit", "c", "pop", "swap", "roll", "pall"));
	private final DecimalFormat df = new DecimalFormat("#,###.#########");
	private final DecimalFormat Sci = new DecimalFormat("0.#########E0");
	private Deque<Double> stack;
	private Calculator calc;

	/**
	 * the class constructor initialises the stack and calc objects
	 */
	public RPNcli() {
		this.stack = new ArrayDeque<>();
		this.calc = new Calculator(stack);
	}

	/**
	 * The method responsible for parsing the input data. If a number, pushes it to
	 * the stack
	 * 
	 * @param input
	 */
	public void parse(String input) {
		String[] parts = input.split(" ");
		for (int i = 0; i < parts.length; i++) {
			try {
				Double num = Double.parseDouble(parts[i]);
				stack.push(num);
			} catch (NumberFormatException e) {
				operation(parts[i]);
			}
		}
	}

	/**
	 * The method decides whether the non-numeral input is a command or an operator
	 * 
	 * @param input
	 */
	private void operation(String input) {
		if (calc.contains(input)) {
			calc.calculate(input);
		} else {
			if (commands.contains(input)) {
				command(input);
			} else {
				System.out.println("ERROR: Invalid Command");
			}
		}
	}

	/**
	 * The method is responsible for executing commands which do not return any
	 * value
	 * 
	 * @param input
	 */
	private void command(String input) {
		switch (input) {
		case "exit":
			System.exit(0);
			break;
		case "p":
			if (stack.size() > 0) {
				double num = stack.peek();
				if (num > 1000000000) {
					System.out.println(Sci.format(num));
				} else {
					System.out.println(df.format(num));
				}
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
			} else {
				System.out.println("ERROR: can't swap empty stack");
			}
			break;
		case "roll":
			double num = stack.pop();
			stack.addLast(num);
			break;
		case "pall":
			System.out.println(Arrays.toString(stack.toArray()));
			break;
		}

	}
}
