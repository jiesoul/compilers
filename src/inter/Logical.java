package inter;

import lexer.Token;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Logical extends Expr {
    public Expr expr1, expr2;
    Logical(Token token, Expr x1, Expr x2) {
        super(token, null);
        this.expr1 = x1;
        this.expr2 = x2;
        type = check(expr1.type, expr2.type);
        if (type == null) {
            error("type error");
        }
    }

    public Type check(Type t1, Type t2) {
        if (t1 == Type.Bool && t2 == Type.Bool) {
            return Type.Bool;
        } else {
            return null;
        }
    }

    public Expr gen() {
        int f = newlabel();
        int a = newlabel();
        Temp temp = new Temp(type);
        this.jumping(0, f);
        emit(temp.toString() + "= true");
        emit("goto L" + a);
        emitlabel(f);
        emit(temp.toString() + " = false");
        emitlabel(a);
        return temp;
    }

    @Override
    public String toString() {
        return "Logical{" +
                "expr1=" + expr1 +
                ", expr2=" + expr2 +
                '}';
    }
}
