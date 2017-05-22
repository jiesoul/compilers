package inter;

import lexer.Word;
import symbols.Type;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Id extends Expr {
    public int offset;
    public Id(Word id, Type type, int b) {
        super(id, type);
        offset = b;
    }
}
