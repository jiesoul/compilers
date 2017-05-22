package inter;

import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class While extends Stmt {
    Expr expr;
    Stmt stmt;
    public While() {
        this.expr = null;
        this.stmt = null;
    }
    public void init(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
        if (expr.type != Type.Bool) {
            expr.error("boolean required is while");
        }
    }
    public void gen(int b, int a) {
        after = a;
        expr.jumping(0, a);
        int label = newlabel();
        emitlabel(label);
        stmt.gen(label, b);
        emit("goto L" + b);
    }
}
