package inter;

import symbols.Array;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class SetElem extends Stmt {
    public Id array;
    public Expr index;
    public Expr expr;
    public SetElem(Access access, Expr expr) {
        this.array = access.array;
        this.index = access.index;
        this.expr = expr;
        if (check(access.type, expr.type) == null) {
            error("type error");
        }
    }
    public Type check(Type t1, Type t2) {
        if (t1 instanceof Array || t2 instanceof Array) {
            return null;
        } else if (t1 == t2) {
            return t2;
        } else if (Type.numeric(t1) && Type.numeric(t2)) {
            return t2;
        } else {
            return null;
        }
    }
    public void gen(int b, int a) {
        String s1 = index.reduce().toString();
        String s2 = expr.reduce().toString();
        emit(array.toString() + " [ " + s1 + " ] = " + s2);
    }
}
