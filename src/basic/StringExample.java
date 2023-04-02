package basic;

public class StringExample {
    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);
        String s3 = s1.intern();
        String s4 = s2.intern();
        System.out.println(s3 == s4);
        String s5 = "bbb";
        String s6 = "bbb";
        System.out.println(s5 == s6);
        float f1 = 1.1F;
        final int x = 1;
//        x = 4; Cannot assign a value to final variable 'x'

    }
}
