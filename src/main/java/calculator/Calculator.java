package calculator;

import java.util.stream.IntStream;

import static java.lang.Integer.*;

public class Calculator {

    public int calculate(String expression) {
        String[] elements = expression.split(" ");

        return IntStream.iterate(1, seed -> seed < elements.length, seed -> seed + 2)
                .reduce(parseInt(elements[0]), (left, right) -> {
                    Operator operator = Operator.expressionOf(elements[right]);
                    int operand = parseInt(elements[right + 1]);
                    return operator.apply(left, operand);
                });
    }

    private enum Operator {
        PLUS("+") {
            @Override
            public int apply(int operand1, int operand2) {
                return operand1 + operand2;
            }
        }, MINUS("-") {
            @Override
            public int apply(int operand1, int operand2) {
                return operand1 - operand2;
            }
        }, DIVIDE("/") {
            @Override
            public int apply(int operand1, int operand2) {
                if (operand2 == 0) {
                    throw new IllegalArgumentException();
                }

                return operand1 / operand2;
            }
        }, MULTIPLY("*") {
            @Override
            public int apply(int operand1, int operand2) {
                return operand1 * operand2;
            }
        };

        Operator(String expression) {
            this.expression = expression;
        }

        public final String expression;

        public static Operator expressionOf(String expression) {
            switch (expression) {
                case "+": {
                    return PLUS;
                }
                case "-": {
                    return MINUS;
                }
                case "/": {
                    return DIVIDE;
                }
                case "*": {
                    return MULTIPLY;
                }
                default:
                    throw new IllegalArgumentException();
            }
        }

        public abstract int apply(int operand1, int operand2);
    }
}
