package owl;

import org.apfloat.Apfloat;
import org.apfloat.ApfloatMath;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.NoSuchElementException;

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


    public Apfloat pop() { // Always use this method within this class. This will prevent exceptions
        try {
            return stack.pop();
        } catch (NoSuchElementException e) {
            // In case of an empty stack, always pop and peek a 0. Infinite precision will be canceled out by
            // later calculations done by the user
            return new Apfloat(0);
        }
    }

    public void clear() {
        stack.clear();
    }

    public Apfloat peek() {
        try {
            return stack.peek();
        } catch (NoSuchElementException e) {
            // In case of an empty stack, always pop and peek a 0. Infinite precision will be canceled out by
            // later calculations done by the user
            return new Apfloat(0);
        }
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
        stack.addLast(pop());
    }

    public void add() {
        stack.push(pop().add(pop()));
    }

    public void subtract() {
        Apfloat num2 = pop();
        Apfloat num1 = pop();
        stack.push(num1.subtract(num2));
    }

    public void multiply() {
        stack.push(pop().multiply(pop()));
    }

    public void divide() {
        Apfloat num2 = pop();
        Apfloat num1 = pop();
        stack.push(num1.divide(num2));
    }

    public void mod() {
        Apfloat num2 = pop();
        Apfloat num1 = pop();
        stack.push(ApfloatMath.fmod(num1, num2));
    }

    public void square() {
        Apfloat toSquare = pop();
        stack.push(toSquare.multiply(toSquare));
    }

    public void sqrt() {
        stack.push(ApfloatMath.sqrt(pop()));
    }

    public void pow() {
        Apfloat num2 = pop();
        Apfloat num1 = pop();
        stack.push(ApfloatMath.pow(num1, num2));
    }

    public void setPrecision() {
        precision = pop().longValue();
    }

    public void setRadix() {
        radix = pop().intValue();
    }

    public void degreeMode(){
        isRadian = false;
    }

    public void radianMode() {
        isRadian = true;
    }

    public void sin() {
        if (isRadian) { // ApfloatMath uses Radians per default
            stack.push(ApfloatMath.sin((pop())));
        } else { // Convert input to radians then push output
            stack.push(ApfloatMath.sin(ApfloatMath.toRadians(pop())));
        }
    }

    public void cos() {
        if (isRadian) { // ApfloatMath uses Radians per default
            stack.push(ApfloatMath.cos(pop()));
        } else { // Convert input to radians then push output
            stack.push(ApfloatMath.cos(ApfloatMath.toRadians(pop())));
        }
    }

    public void tan() {
        if (isRadian) { // ApfloatMath uses Radians per default
            stack.push(ApfloatMath.tan(pop()));
        } else { // Convert input to radians then push output
            stack.push(ApfloatMath.tan(ApfloatMath.toRadians(pop())));
        }
    }

    public void asin() {
        if (isRadian) { // ApfloatMath uses Radians per default
            stack.push(ApfloatMath.asin((pop())));
        } else { // Convert input to radians then push output
            stack.push(ApfloatMath.toDegrees(ApfloatMath.asin(pop())));
        }
    }

    public void acos() {
        if (isRadian) { // ApfloatMath uses Radians per default
            stack.push(ApfloatMath.acos((pop())));
        } else { // Convert input to radians then push output
            stack.push(ApfloatMath.toDegrees(ApfloatMath.acos(pop())));
        }
    }

    public void atan() {
        if (isRadian) { // ApfloatMath uses Radians per default
            stack.push(ApfloatMath.atan((pop())));
        } else { // Convert input to radians then push output
            stack.push(ApfloatMath.toDegrees(ApfloatMath.atan(pop())));
        }
    }

    /**
     * The factorial function. Can be applied only to integers; otherwise it does nothing.
     */
    public void fact() {
        if (ApfloatMath.fmod(peek(), new Apfloat("1")).equals(new Apfloat("0"))) {
            Apfloat product = pop();
            for (Apfloat num = product.subtract(new Apfloat("1", precision)); num.compareTo(new Apfloat("0")) > 0; num = num.subtract(new Apfloat("1", precision))) {
                product = product.multiply(num);
            }
            stack.push(product);
        }
    }

    public String toString() {
        return Arrays.toString(stack.toArray());
    }


}
