package owl;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Calculator {
    private final Deque<Apfloat> stack;
    private boolean isRadian;
    private long precision;
    private int radix;

    /**
     * Constructs the calculator object, which computes and stores numbers in a stack. All operations follow the basic
     * RPN procedures.
     * @param isRadian sets the mode to either Radian or Degree for Trig. functions
     * @param precision sets the precision of the calculator
     * @param radix sets the base of the number system
     */
    public Calculator(boolean isRadian, long precision, int radix) {
        stack = new ArrayDeque<>();
        this.isRadian = isRadian;
        this.precision = precision;
        this.radix = radix;
    }

    public Calculator(boolean isRadian, long precision) {
        this(isRadian, precision, 10);
    }

    public Calculator(boolean isRadian) {
        this(isRadian, 1, 10);
    }

    public Calculator(long precision) {
        this(true, precision, 10);
    }

    public Calculator() {
        this(true, 1, 10);
    }

    public void push(String num) {
        stack.push(new Apfloat(num, precision, radix));
    }

    public Apfloat pop() {
        return stack.pop();
    }

    public void clear() {
        stack.clear();
    }

    public Apfloat peek() {
        return stack.peek();
    }

    public void swap() {
        // Pop the X and Y stacks
        Apfloat num1 = stack.pop();
        Apfloat num2 = stack.pop();
        // Push Y onto X and vice versa
        stack.push(num2);
        stack.push(num1);
    }

    public void roll() {
        stack.addLast(stack.pop());
    }

    public void add() {
        stack.push(stack.pop().add(stack.pop()));
    }

    public void subtract() {
        Apfloat num2 = stack.pop();
        Apfloat num1 = stack.pop();
        stack.push(num1.subtract(num2));
    }

    public void multiply() {
        stack.push(stack.pop().multiply(stack.pop()));
    }

    public void divide() {
        Apfloat num2 = stack.pop();
        Apfloat num1 = stack.pop();
        stack.push(num1.divide(num2));
    }

    public void mod() {
        Apfloat num2 = stack.pop();
        Apfloat num1 = stack.pop();
        stack.push(ApfloatMath.fmod(num1, num2));
    }

    public void setPrecision() {
        precision = stack.pop().longValue();
    }

    public void setRadix() {
        radix = stack.pop().intValue();
    }

    public void degreeMode(){
        isRadian = false;
    }

    public void radianMode() {
        isRadian = true;
    }

    public void sin() {
        stack.push(ApfloatMath.sin((stack.pop())));
    }

    public void cos() {
        stack.push(ApfloatMath.cos(stack.pop()));
    }

    public void tan() {
        stack.push(ApfloatMath.tan(stack.pop()));
    }

    public String toString() {
        return Arrays.toString(stack.toArray());
    }


}
