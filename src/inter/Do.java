package inter;

import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Do extends Stmt {
    Expr expr;
    Stmt stmt;
    public Do() {
        this.expr = null;
        this.stmt = null;
    }
    public void init(Stmt stmt, Expr expr) {
        this.expr = expr;
        this.stmt = stmt;
        if (expr.type != Type.Bool) {
            expr.error("boolean required in do");
        }
    }
    public void gen(int b, int a) {
        after = a;
        int label = newlabel();
        stmt.gen(b, label);
        emitlabel(label);
        expr.jumping(b, 0);
    }
}
