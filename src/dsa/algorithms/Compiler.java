package dsa.algorithms;

public interface Compiler {

    String infixToPostfix(String infix);
    String infixToPrefix(String infix);

    int evaluatePostfix(String postfix);
    int evaluatePrefix(String prefix);
}
