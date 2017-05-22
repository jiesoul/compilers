package symbols;

import lexer.Tag;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Array extends Type {
    public Type of;
    public int size = 1;
    public Array(int size, Type type) {
        super("[]", Tag.INDEX, size * type.width);
        this.size = size;
        this.of = type;
    }

    @Override
    public String toString() {
        return "Array{" +
                "of=" + of +
                ", size=" + size +
                '}';
    }
}
