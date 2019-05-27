import java.util.Arrays;

/**
 * create by Canon4G 2019-05-24
 **/
public class ArrayTest {

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest(10);
        arrayTest.insert(1, 0);
        arrayTest.insert(2, 0);
        arrayTest.insert(3, 0);
        arrayTest.print();
        arrayTest.update(2, 0);
        arrayTest.print();
        arrayTest.delete(0);
        arrayTest.print();
        System.out.println(arrayTest.search(0));
        arrayTest.insert(1, 10);
        arrayTest.print();
    }

    private static int[] arr;

    public ArrayTest(int size) {
        this.arr = new int[size];
    }

    /**
     * 插入
     * @param element 元素
     * @param index   索引
     */
    private void insert(int element, int index) {
        if (0 > index) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        if (index > arr.length - 1) {
            resize();
        }
        for (int i = arr.length - 1; i >= index; i--) {
            if (0 != i) {
                arr[i] = arr[i - 1];
            }
        }
        arr[index] = element;
    }

    /**
     * 删除
     * @param index 索引
     */
    private void delete(int index) {
        if (0 > index || index > arr.length - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    /**
     * 更新
     * @param element 元素
     * @param index   索引
     */
    private void update(int element, int index) {
        if (0 > index || index > arr.length - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        arr[index] = element;
    }

    /**
     * 查询
     * @param index 索引
     */
    private int search(int index) {
        if (0 > index || index > arr.length - 1) {
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];
    }

    /**
     * 数组扩容
     */
    private void resize() {
        int[] arrNew = new int[arr.length * 2];
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        arr = arrNew;
    }

    /**
     * 打印数组
     */
    private void print() {
        System.out.println(Arrays.toString(arr));
    }
}
