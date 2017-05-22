package lexer;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Token {
    public final int tag;
    public Token(int t) {
        this.tag = t;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tag=" + tag +
                '}';
    }
}
