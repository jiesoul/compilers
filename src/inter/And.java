package inter;

import lexer.Token;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class And extends Logical {
    public And(Token token, Expr e1, Expr e2) {
        super(token, e1, e2);
    }
    public void jumping(int t, int f) {
        int label = f != 0 ? f : newlabel();
        expr1.jumping(0, label);
        expr2.jumping(t, f);
        if (f == 0) {
            emitlabel(label);
        }
    }
}
