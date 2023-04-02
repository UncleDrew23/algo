package basic;

import basic.Dog;

public class PassByValueExample {
    public static void main(String[] args) {
        Dog dog = new Dog("A");//Dog dog 的 dog 是一个指针，存储的是对象的地址。在将一个参数传入一个方法时，本质上是将对象的地址以值的方式传递到形参中
        System.out.println(dog.getName());
        System.out.println(dog.getObjectAddress());
        func(dog);
        System.out.println(dog.getName());
        System.out.println(dog.getObjectAddress());
    }

    private static void func(Dog dog) {
//        dog.setName("B");//改变对象的字段值会改变原对象该字段值，因为引用的是同一个对象
        System.out.println(dog.getObjectAddress());
        dog = new Dog("B");//将指针引用了其它对象，那么此时方法里和方法外的两个指针指向了不同的对象，在一个指针改变其所指向对象的内容对另一个指针所指向的对象没有影响
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());
    }
}
