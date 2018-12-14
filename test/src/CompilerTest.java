import dsa.algorithms.Compiler;
import org.junit.Assert;
import org.junit.Test;
import practices.waterball.adt.WbCompiler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CompilerTest {
    Compiler compiler = new WbCompiler();  //replace it with your compiler

    @Test
    public void test(){
        String infix = "5 + 6 * ( 7 - 15 / 3 ) - 2";
        String prefix = "- * A ↑ B + C - D E * E F";
        String postfix = "5 6 7 15 3 / - * + 2 -";

        assertEquals(postfix, compiler.infixToPostfix(infix));
        assertEquals(15, compiler.evaluatePostfix(postfix));
    }

}
