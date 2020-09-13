package owl;

public class JRPN {
    public static void main(String[] args) {
        Calculator calc = new Calculator(10);
        calc.push("55");
        calc.push("5");
        calc.divide();
        calc.cos();
        System.out.println(calc.peek());
    }
}
