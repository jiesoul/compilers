package inter;

import lexer.Num;
import lexer.Token;
import lexer.Word;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Constant extends Expr {
    public Constant(Token token, Type type) {
        super(token, type);
    }
    public Constant(int i) {
        super(new Num(i), Type.Int);
    }
    public static final Constant True = new Constant(Word.True, Type.Bool);
    public static final Constant False = new Constant(Word.False, Type.Bool);
    public void jumping(int t, int f) {
        if (this == True && t != 0) {
            emit("goto L" +  t);
        } else if (this == False && f != 0) {
            emit("goto L" + f);
        }
    }
}
