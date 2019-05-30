import java.util.Arrays;

/**
 * create by Canon4G 2019-05-30
 **/
public class SortTest {

    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 3, 5, 4, 6, 7};
//        bubbleSort(a);
//        bubbleSort1(a);
        bubbleSort2(a);
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

    /**
     * 优化冒泡排序
     * @param arr       待排序数组
     */
    private static void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 元素交换标志
            boolean swapFlag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }

    /**
     * 优化冒泡排序
     * @param arr       带排序数组
     */
    private static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 元素交换标志
            boolean swapFlag = false;
            // 最后进行交换的元素位置(无序的边界，不用全部比较，只比较无序部分即可)
            int swapIndex = arr.length - 1;
            for (int j = 0; j < swapIndex; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                    swapIndex = j;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }
}
