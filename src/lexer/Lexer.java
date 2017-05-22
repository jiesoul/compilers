package lexer;

import symbols.Type;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Lexer {

    public static int line = 1; // line number
    char peek = ' '; // 当前字符
    Hashtable words = new Hashtable(); // 字典表

    void reserve(Word w) {
        words.put(w.lexeme, w);
    }
    public Lexer() {
        reserve(new Word("if", Tag.IF));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("break", Tag.BREAK));
        reserve(Word.True);
        reserve(Word.False);
        reserve(Type.Int);
        reserve(Type.Char);
        reserve(Type.Bool);
        reserve(Type.Float);
    }

    // 读取下一字符
    void readch() throws IOException {
        peek = (char)System.in.read();
    }

    // 重载方法，检查字符是否与下一字符相等
    boolean readch(char c) throws IOException {
        readch();
        if (peek != c) {
            return false;
        }
        peek = ' ';
        return true;
    }

    // 扫描方法
    public Token scan() throws IOException {

        // 跳过空字符或者，换行时 把行号加1
        for (;;readch()) {
            if (peek == ' ' || peek == '\t') {
                continue;
            } else if (peek == '\n') {
                line = line + 1;
            } else {
                break;
            }
        }

        // 转换当前字符，如果匹配返回下就的Token，挑选符号 || && 之类的终端符
        switch (peek) {
            case '&':
                if (readch('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Word.eq;
                } else {
                    new Token('=');
                }
            case '!':
                if (readch('=')) {
                    return Word.ne;
                } else {
                    return new Token('!');
                }
            case '<':
                if (readch('=')) {
                    return Word.le;
                } else {
                    new Token('<');
                }
            case '>':
                if (readch('=')) {
                    return Word.ge;
                } else {
                    return new Token('>');
                }

        }

        // 数字匹配
        if (Character.isDigit(peek)) {
            int v = 0;
            // 整数循环提取
            do {
                v = 10 * v + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));

            // 小数点
            if (peek != '.') {
                return new Num(v);
            }

            // float 处理
            float x = v;
            float d = 10;
            for (;;) {
                readch();
                if (!Character.isDigit(peek)) {
                    break;
                }
                x = x + Character.digit(peek, 10) / d;
                d = d * 10;
            }

            return new Real(x);
        }

        // 标识符
        if (Character.isLetter(peek)) {
            StringBuilder b = new StringBuilder();
            do {
                b.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek));

            String s = b.toString();
            Word w = (Word) words.get(s);
            if (w != null) {
                return w;
            }
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }

        // 任意字符做为词法单元返回
        Token tok = new Token(peek);
        peek = ' ';
        return tok;
    }
}
