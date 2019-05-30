import java.util.Arrays;

/**
 * create by Canon4G 2019-05-30
 **/
public class SortTest {

    public static void main(String[] args) {
        int[] a = new int[] {3, 2, 1};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    
    /**
     * 冒泡排序
     * @param arr       待排序数组
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
