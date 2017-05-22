package inter;

import lexer.Token;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Not extends Logical {
    public Not(Token token, Expr e2) {
        super(token, e2, e2);
    }
    public void jumping(int t, int f) {
        expr2.jumping(f, t);
    }

    public String toString () {
        return op.toString() + " " + expr2.toString();
    }
}
