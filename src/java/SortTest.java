import java.util.Arrays;

/**
 * create by Canon4G 2019-05-30
 **/
public class SortTest {

    public static void main(String[] args) {
        int[] a = new int[] {2, 3, 4, 5, 6, 1, 7};
//        bubbleSort(a);
//        bubbleSort1(a);
//        bubbleSort2(a);
//        cocktailSort(a);
//        cocktailSort1(a);
        cocktailSort2(a);
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
     * @param arr       待排序数组
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

    /**
     * 鸡尾酒排序
     * @param arr       待排序数组
     */
    private static void cocktailSort(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            // 正序遍历排序
            int temp;
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 倒叙遍历排序
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 优化鸡尾酒排序
     * @param arr       待排序数组
     */
    private static void cocktailSort1(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            // 正序遍历排序
            int temp;
            // 元素交换标识
            boolean swapFlag = false;
            for (int j = i; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
            // 倒叙遍历排序
            // 重新初始化元素交换标识
            swapFlag = false;
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }
        }
    }

    /**
     * 优化鸡尾酒排序
     * @param arr       待排序数组
     */
    private static void cocktailSort2(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            // 正序遍历
            int temp;
            // 元素交换标识
            boolean swapFlag = false;
            // 正序遍历无序边界
            int swapIndexAsc = arr.length - i - 1;
            for (int j = i; j < swapIndexAsc; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapFlag = true;
                    swapIndexAsc = j;
                }
            }
            if (!swapFlag) {
                break;
            }
            // 重新初始化元素交换标识
            swapFlag = false;
            for (int j = arr.length - 1; i < j; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapFlag = true;
                }
            }
            if (!swapFlag) {
                break;
            }

        }
    }
}
