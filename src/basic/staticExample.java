package basic;

public class staticExample {
    private int x;
    private static int y;

    static {
        System.out.println("123"); //静态语句块在类初始化时运行一次
    }

    public static void func1() {
        int a = y;
    }

    public static void main(String[] args) {
        staticExample a1 = new staticExample();
        staticExample a2 = new staticExample();
    }
}
