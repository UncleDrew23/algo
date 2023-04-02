package basic;

/**
 * @descriptions: TODO
 * @author: ycbron
 * @date: 2023/4/2 23:32
 * @version: 1.0
 */
public class ShallowCloneExample implements Cloneable{
    private int[] arr;

    public ShallowCloneExample() {
        arr = new int[10];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void set(int index, int value) {
        arr[index] = value;
    }

    public int get(int index) {
        return arr[index];
    }

    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }
}
