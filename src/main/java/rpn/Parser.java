package rpn;

import java.util.Stack;
import java.util.function.DoubleBinaryOperator;

class Parser {
    static double eval(String expression) {
        Stack<Double> stack = new Stack<>();

        for (String expressionElement : expression.split(" ")) {
            switch (expressionElement) {
                case "*":
                    Parser.evalOperation(stack, (a, b) -> a * b);
                    break;
                case "/":
                    Parser.evalOperation(stack, (a, b) -> b / a);
                    break;
                case "+":
                    Parser.evalOperation(stack, (a, b) -> a + b);
                    break;
                case "-":
                    Parser.evalOperation(stack, (a, b) -> b - a);
                    break;
                default:
                    stack.push(Double.parseDouble(expressionElement));
            }
        }

        return stack.pop();
    }

    private static void evalOperation(Stack<Double> stack, DoubleBinaryOperator operation) {
        stack.push(operation.applyAsDouble(stack.pop(), stack.pop()));
    }
}
