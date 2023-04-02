package basic;

public class EqualExample {
    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    //检查是否为同一个对象的引用，如果是直接返回 true；
    //检查是否是同一个类型，如果不是，直接返回 false；
    //将 Object 对象进行转型；
    //判断每个关键域是否相等。
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        EqualExample that = (EqualExample) obj;
        if(x != that.x) return false;
        if(y != that.y) return false;
        return z == that.z;
    }
}
