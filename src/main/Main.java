package main;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Main {

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        Parser parse = new Parser(lex);
        parse.program();
        System.out.write('\n');
    }
}
