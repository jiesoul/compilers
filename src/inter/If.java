package inter;

import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class If extends Stmt {
    Expr expr;
    Stmt stmt;
    public If(Expr expr, Stmt stmt) {
        this.expr = expr;
        this.stmt = stmt;
        if (expr.type != Type.Bool) {
            expr.error("boolean require in if");
        }
    }
    public void gen(int b, int a) {
        int label = newlabel();
        expr.jumping(0, a);
        emitlabel(label);
        stmt.gen(label, a);
    }
}
