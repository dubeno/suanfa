package corejava;

/**
 * First, parent static items, then child static items
 * Then parent member variables, followed by the parent constructor
 * Then child member variables, followed by the child constructor
 * @author robin
 */
public class TestInitialOrder {
    public static void main(String[] args) {
        InitailOrder order = new SubClassInitialOrder();
    }
}
class InitailOrder{
    static {
        System.out.println("静态代码块");
    }
    static String a = verify("静态变量初始化");
    String nonStatic = verify("成员变量初始化");
    public InitailOrder() {
        System.out.println("构造函数");
    }
    static String verify(String s) {
        System.out.println(s);  return s;
    }
}
class SubClassInitialOrder extends InitailOrder{
    static String c = verify("子类静态变量初始化");
    String d = verify("子类成员变量初始化");
    static {
        System.out.println("子类静态代码块");
    }
    static String verify(String s) {
        System.out.println(s);
        return s;
    }

    public SubClassInitialOrder() {
        System.out.println("子类构造函数执行");
    }
}
