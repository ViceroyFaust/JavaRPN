package owl;

public class JRPN {
    public static void main(String[] args) {
        Calculator calc = new Calculator(10);
        calc.push("70");
        calc.fact();
        System.out.println(calc.peek());
    }
}
