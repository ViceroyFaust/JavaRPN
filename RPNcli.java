package owl;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Deque;

public class RPNcli {
	private final Set<String> commands = new HashSet<>(Arrays.asList("p", "e", "c", "pop", "swap"));
	private Deque<Double> stack;
	private Calculator calc;
	
	public RPNcli () {
		this.stack = new ArrayDeque<>();
		this.calc = new Calculator(stack);
	}
	
	public void parse(String input) {
        String[] parts = input.split(" ");
        for (int i = 0; i < parts.length; i++) {
            try {
                Double num = Double.parseDouble(input);
                stack.push(num);
            } catch (NumberFormatException ex) { 
                operation(parts[i]);
            }
        }
    }

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
	
	private void command(String input) {
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
}
