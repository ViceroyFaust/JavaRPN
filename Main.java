package owl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.println("JavaRPN: Input numbers and operands separated by newline or space");
			RPNcli cli = new RPNcli();
			while (true) {
				String input = reader.readLine().toLowerCase();
				cli.parse(input);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
}
