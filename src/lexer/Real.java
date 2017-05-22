package lexer;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Real extends Token {
    public final float value;
    public Real(float v) {
        super(Tag.REAL);
        this.value = v;
    }

    @Override
    public String toString() {
        return "Real{" +
                "value=" + value +
                '}';
    }
}
