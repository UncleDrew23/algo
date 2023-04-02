package basic;

public class CloneExampleTest {
    public static void main(String[] args) throws CloneNotSupportedException {
//        CloneExample e1 = new CloneExample();
////        CloneExample e2 = e1.clone(); 'clone()' has protected access in 'java.lang.Object'
//        CloneExample e2 = e1.clone();//Exception in thread "main" java.lang.CloneNotSupportedException: basic.CloneExample

        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        System.out.println(e1.get(2));
        e2 = e1.clone();
        System.out.println(e2.get(2));
        e1.set(2, 222);
        System.out.println(e1.get(2));
        System.out.println(e2.get(2));
    }
}
