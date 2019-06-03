import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
//        cocktailSort2(a);
//        quickSortDouble(a, 0, a.length - 1);
//        quickSortSingle(a, 0, a.length - 1);
        quickSortSingleByStack(a, 0, a.length - 1);
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

    /**
     * 快速排序(单边循环)
     * @param arr           待排序数组
     * @param startIndex    起点左边
     * @param endIndex      终点坐标
     */
    private static void quickSortSingle(int[] arr, int startIndex, int endIndex) {
        while (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = getPivotIndexSingle(arr, startIndex, endIndex);
        // 分治法
        quickSortSingle(arr, startIndex, pivotIndex - 1);
        quickSortSingle(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 获得基准元素位置(单边循环)
     * @param arr           待排序数组
     * @param startIndex    起点坐标
     * @param endIndex      终点坐标
     * @return
     */
    private static int getPivotIndexSingle(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        int mark = startIndex;
        int temp;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (arr[i] < pivot) {
                mark++;
                temp = arr[mark];
                arr[mark] = arr[i];
                arr[i] = temp;
            }
        }
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    /**
     * 快速排序(单边循环) 非递归
     * @param arr           待排序数组
     * @param startIndex    起点左边
     * @param endIndex      终点坐标
     */
    private static void quickSortSingleByStack(int[] arr, int startIndex, int endIndex) {
        // 用一个集合栈去代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 整个数列的起止下标，以哈希的形式入栈
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIndex", startIndex);
        rootParam.put("endIndex", endIndex);
        quickSortStack.push(rootParam);

        // 循环结束条件：栈为空
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，获得起止下边
            Map<String, Integer> param = quickSortStack.pop();
            if (param.get("startIndex") != endIndex) {
                // 获得基准元素位置 单边循环法
                int pivotIndex = getPivotIndexSingle(arr, param.get("startIndex"), param.get("endIndex"));
                // 根据基准元素分成两部分，把每一部分的起止下标入栈
                if (param.get("startIndex") < pivotIndex - 1) {
                    Map<String, Integer> leftParam = new HashMap<>();
                    leftParam.put("startIndex", param.get("startIndex"));
                    leftParam.put("endIndex", pivotIndex - 1);
                    quickSortStack.push(leftParam);
                }
                if (pivotIndex - 1 < param.get("endIndex")) {
                    Map<String, Integer> rightParam = new HashMap<>();
                    rightParam.put("startIndex", pivotIndex + 1);
                    rightParam.put("endIndex", param.get("endIndex"));
                    quickSortStack.push(rightParam);
                }
            }
        }
    }

    /**
     * 快速排序(双边循环)
     * @param arr           待排序数组
     * @param startIndex    起点坐标
     * @param endIndex      终点坐标
     */
    private static void quickSortDouble(int[] arr, int startIndex, int endIndex) {
        while (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = getPivotIndexDouble(arr, startIndex, endIndex);
        // 分治法进行下两组快排
        quickSortDouble(arr, startIndex, pivotIndex - 1);
        quickSortDouble(arr, pivotIndex + 1, endIndex);
    }

    /**
     * 获得基准元素位置(双边循环)
     * @param arr           待排序数组
     * @param startIndex    起始点
     * @param endIndex      结束点
     */
    private static int getPivotIndexDouble(int[] arr, int startIndex, int endIndex) {
        int pivot = arr[startIndex];
        // 初始化左指针和右指针
        int left = startIndex;
        int right = endIndex;

        while (left != right) {
            // 右指针操作：比较同时向左移动指针
            while (left < right && arr[right] > pivot) {
                right--;
            }
            // 左指针操作：比较同时向右移动指针
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            // 进行元素交换
            if (left < right) {
                int a = arr[left];
                arr[left] = arr[right];
                arr[right] = a;
            }
        }
        // 把基准元素和left和right的重合点元素进行交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
