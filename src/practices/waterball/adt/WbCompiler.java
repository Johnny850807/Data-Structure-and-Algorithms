package practices.waterball.adt;

import dsa.algorithms.Compiler;

import java.util.*;

import static practices.waterball.adt.Operator.*;

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
            else  //operand
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
        StringTokenizer tokenizer = new StringTokenizer(infix);
        return null;
    }

    @Override
    public int evaluatePostfix(String postfix) {
        StringTokenizer tokenizer = new StringTokenizer(postfix);
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

    @Override
    public int evaluatePrefix(String prefix) {
        StringTokenizer tokenizer = new StringTokenizer(prefix);
        return 0;
    }

}
