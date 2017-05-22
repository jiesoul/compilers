package inter;

import lexer.Token;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Unary extends Op {
    public Expr expr;
    public Unary(Token token, Expr expr) {
        super(token, null);
        this.expr = expr;
        type = Type.max(Type.Int, expr.type);
        if (type == null) {
            error("type error");
        }
    }
    public Expr gen() {
        return new Unary(op, expr.reduce());
    }

    @Override
    public String toString() {
        return "Unary{" +
                "expr=" + expr +
                '}';
    }
}
