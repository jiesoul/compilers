package inter;

import lexer.Token;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Op extends Expr {
    public Op(Token token, Type type) {
        super(token,type);
    }
    public Expr reduce() {
        Expr x = gen();
        Temp t = new Temp(type);
        emit(t.toString() + " = " + x.toString());
        return t;
    }
}
