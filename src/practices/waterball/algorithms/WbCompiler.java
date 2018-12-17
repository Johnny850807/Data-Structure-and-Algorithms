package practices.waterball.algorithms;

import dsa.algorithms.Compiler;
import practices.waterball.Operator;

import java.util.*;

import static practices.waterball.Operator.*;

public class WbCompiler implements Compiler{


    @Override
    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(infix);
        Stack<String> stack = new Stack<>();

        while (tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            if (token.equals("("))
            {
                stack.push("(");
            }
            else if(isOperator(token))
            {
                while(!stack.isEmpty()
                        && !stack.peek().equals("(")
                        && priority(token) <= priority(stack.peek()))
                {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
            else if (token.equals(")"))
            {
                while(!stack.peek().equals("("))
                {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); //pop "("
            }
            else  //is operand
            {
                postfix.append(token).append(" ");
            }
        }

        while (!stack.isEmpty())
            postfix.append(stack.pop()).append(" ");

        return postfix.toString().trim();
    }

    @Override
    public String infixToPrefix(String infix) {
        StringTokenizer tokenizer = reverseStringTokenizer(new StringTokenizer(infix));
        StringBuilder prefix = new StringBuilder();
        Stack<String> prefixStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        while(tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            if (token.equals(")"))
            {
                operatorStack.push(token);
            }
            else if (isOperator(token))
            {
                while(!operatorStack.isEmpty() &&
                        !operatorStack.peek().equals(")") &&
                        priority(token) < priority(operatorStack.peek()))  //note that left-associate uses '<' rather than '<='
                {
                    prefixStack.push(operatorStack.pop());
                }
                operatorStack.push(token);
            }
            else if (token.equals("("))
            {
                while(!operatorStack.peek().equals(")"))
                {
                    prefixStack.push(operatorStack.pop());
                }
                operatorStack.pop();  //pop the ')'
            }
            else  //is operand
            {
                prefixStack.push(token);
            }
        }

        while (!operatorStack.isEmpty())
            prefixStack.push(operatorStack.pop());

        while (!prefixStack.isEmpty())
            prefix.append(prefixStack.pop()).append(" ");

        return prefix.toString().trim();
    }

    @Override
    public int evaluateInfix(String infix) {
        return evaluatePostfix(infixToPostfix(infix));
    }

    @Override
    public int evaluatePostfix(String postfix) {
        StringTokenizer tokenizer = new StringTokenizer(postfix);  //reverse: read from right to left
        Stack<String> stack = new Stack<>();
        while(tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            if (isOperand(token))
            {
                stack.push(token);
            }
            else
            {
                 Operator operator = fromToken(token);
                 int num2 = Integer.parseInt(stack.pop()); //note the first popped element is the second operand
                 int num1 = Integer.parseInt(stack.pop());
                 int result = operator.apply(num1, num2);
                 stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /*
        Almost as same as evaluating Postfix
     */
    @Override
    public int evaluatePrefix(String prefix) {
        StringTokenizer tokenizer = reverseStringTokenizer(new StringTokenizer(prefix));  //reverse: read from right to left
        Stack<String> stack = new Stack<>();
        while(tokenizer.hasMoreTokens())
        {
            String token = tokenizer.nextToken();
            if (isOperand(token))
            {
                stack.push(token);
            }
            else
            {
                Operator operator = fromToken(token);
                int num1 = Integer.parseInt(stack.pop()); //note the first popped element is the second operand
                int num2 = Integer.parseInt(stack.pop());
                int result = operator.apply(num1, num2);
                stack.push(String.valueOf(result));
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * e.g. 1 + 23 * 57  => 57 * 23 + 1
     */
    private StringTokenizer reverseStringTokenizer(StringTokenizer tokenizer){
        Stack<String> stack = new Stack<>();
        while (tokenizer.hasMoreTokens())
            stack.push(tokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty())
            stringBuilder.append(stack.pop()).append(" ");
        String reverseTokenStr = stringBuilder.toString().trim();
        return new StringTokenizer(reverseTokenStr);
    }

}
