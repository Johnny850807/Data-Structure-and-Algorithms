package practices.waterball;

import java.util.function.BiFunction;

public enum Operator {
    POW("^", 9, (a,b) -> (int) Math.pow(a,b)),
    MUL("*", 8, (a,b) -> a*b),
    DIV("/", 8, (a,b) -> a/b),
    PLUS("+", 7, (a,b) -> a+b),
    MINUS("-", 7, (a,b) -> a-b);

    String token;
    int priority;
    int operandNumber;
    BiFunction<Integer, Integer, Integer> twoOperandFunction;

    Operator(String token, int priority, BiFunction<Integer, Integer, Integer> twoOperandFunction) {
        this.token = token;
        this.priority = priority;
        this.operandNumber = 2;
        this.twoOperandFunction = twoOperandFunction;
    }

    public static boolean isOperator(String token){
        return fromToken(token) != null;
    }

    public static boolean isOperand(String token){
        return fromToken(token) == null;
    }

    public static int priority(String token){
        return fromToken(token).priority;
    }

    public static Operator fromToken(String token){
        for (Operator op : Operator.values())
            if (op.token.equals(token))
                return op;
        return null;
    }

    public int apply(int a, int b){
        return twoOperandFunction.apply(a, b);
    }

}
