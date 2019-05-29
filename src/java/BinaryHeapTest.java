import java.util.Arrays;

/**
 * create by Canon4G 2019-05-29
 **/
public class BinaryHeapTest {

    public static void main(String[] args) {
        int[] array = {10, 2, 3, 4, 0};
        System.out.println(Arrays.toString(array));
        upAdjust(array);
        System.out.println(Arrays.toString(array));
        buildHeap(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 创建二叉堆
     * @param arr   二叉堆
     */
    private static void buildHeap(int[] arr) {
        // 从最后一个非叶子节点开始下沉
        for (int i  = (arr.length - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i);
        }
    }

    /**
     * 上浮调整
     * @param arr   二叉堆
     */
    private static void upAdjust(int[] arr) {
        int childIndex = arr.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = arr[childIndex];
        while (0 < childIndex && temp < arr[parentIndex]) {
            arr[childIndex] = arr[parentIndex];
            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
        arr[childIndex] = temp;
    }

    /**
     * 下沉调整
     * @param arr           二叉堆
     * @param parentIndex   下沉节点
     */
    private static void downAdjust(int[] arr, int parentIndex) {
        int temp = arr[parentIndex];
        int childIndex = (2 * parentIndex) + 1;
        while (childIndex < arr.length) {
            // 右孩子节点存在 且 小于左孩子节点 选择右孩子节点
            if (childIndex + 1 < arr.length && arr[childIndex] > arr[childIndex + 1]) {
                childIndex++;
            }
            // 父节点小于所有
            if (temp <= arr[childIndex]) {
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = (2 * parentIndex) + 1;
        }
        arr[parentIndex] = temp;
    }
}
