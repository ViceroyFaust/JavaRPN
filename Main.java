package owl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The JavaRPN calculator. The input is inspired by the old Unix dc calculator
 * program. All standard RPN rules apply.
 * 
 * @author D. F. Owl
 * @version in-development
 */
public class Main {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("JavaRPN: Input numbers and operands separated by newline or space");
			RPNcli cli = new RPNcli();
			while (true) {
				String input = reader.readLine();
				cli.parse(input);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
