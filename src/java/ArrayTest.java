package java;

/**
 * create by Canon4G 2019-05-24
 **/
public class ArrayTest {

    public static void main(String[] args) {
        ArrayTest array = new ArrayTest(10);
        array.insert(1, 0);
        array.insert(2, 0);
        array.insert(3, 0);
        array.insert(4, 0);
        array.print();
    }

    private int[] array;
    private int size;

    public ArrayTest(int capacity) {
        this.array = new int[capacity];
        size = 0;
    }

    /**
     * 插入
     * @param element   元素值
     * @param index     索引
     */
    private void insert(int element, int index) {
        if (0 < index || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }
        for (int i = size - 1; i >= i; i--) {
            array[i + 1] = array[index];
        }
        array[index] = element;
        size++;
    }

    /**
     * 打印数组
     */
    private void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
}
