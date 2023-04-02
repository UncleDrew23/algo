package basic;

public class Dog {
    String name;

    Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObjectAddress() {
        return super.toString();
    }
}
