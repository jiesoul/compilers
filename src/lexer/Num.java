package lexer;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Num extends Token {
    public final int value;
    public Num(int v) {
        super(Tag.NUM);
        this.value = v;
    }

    @Override
    public String toString() {
        return "Num{" +
                "value=" + value +
                '}';
    }
}
