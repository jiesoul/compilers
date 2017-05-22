package inter;

/**
 * Created by zhangyunjie on 2017/5/22.
 */
public class Stmt extends Node {
    public Stmt() {

    }
    public static Stmt Null = new Stmt();
    public void gen(int b, int a) {}
    int after = 0;
    public static Stmt Enclosing = Stmt.Null;
}
