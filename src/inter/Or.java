package inter;

import lexer.Token;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Or extends Logical {
    public Or(Token token, Expr e1, Expr e2) {
        super(token, e1, e2);
    }
    public void jumping(int t, int f) {
        int label = t != 0 ? t : newlabel();
        expr1.jumping(label, 0);
        expr2.jumping(t, f);
        if (t == 0) {
            emitlabel(label);
        }
    }
}
