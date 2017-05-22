package inter;

import lexer.Token;
import symbols.Array;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Rel extends Logical {
    public Rel(Token token, Expr e1, Expr e2) {
        super(token, e1, e2);

    }
    public Type check(Type t1, Type t2) {
        if (t1 instanceof Array || t2 instanceof Array) {
            return null;
        } else if (t1 == t2) {
            return Type.Bool;
        } else {
            return null;
        }

    }

    public void jumping(int t, int f) {
        Expr a = expr1.reduce();
        Expr b = expr2.reduce();

        String test = a.toString() + " " + op.toString() + " " + b.toString();
        emitjumps(test, t, f);

    }

}
